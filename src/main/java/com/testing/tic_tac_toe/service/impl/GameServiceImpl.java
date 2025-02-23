package com.testing.tic_tac_toe.service.impl;

import com.testing.tic_tac_toe.domain.entity.GameEntity;
import com.testing.tic_tac_toe.domain.entity.MoveEntity;
import com.testing.tic_tac_toe.errorhandling.exception.InvalidBodyException;
import com.testing.tic_tac_toe.mapper.GameMapper;
import com.testing.tic_tac_toe.payload.request.CreateGameRequest;
import com.testing.tic_tac_toe.payload.request.MakeMoveRequest;
import com.testing.tic_tac_toe.payload.response.GameResponse;
import com.testing.tic_tac_toe.repository.GameRepository;
import com.testing.tic_tac_toe.repository.MoveRepository;
import com.testing.tic_tac_toe.service.GameHelperService;
import com.testing.tic_tac_toe.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final MoveRepository moveRepository;
    private final GameHelperService gameHelperService;

    @Override
    public Mono<GameResponse> createGame(CreateGameRequest request) {
        if (request.getRow() < 3 || request.getColumn() < 3) {
            throw new InvalidBodyException("Row and column are not valid!");
        }

        GameEntity gameEntity = new GameEntity();
        gameEntity.setId(UUID.randomUUID());
        gameEntity.setPlayer1Id(request.getPlayer1Id());
        gameEntity.setPlayer2Id(request.getPlayer2Id());
        gameEntity.setRw(request.getRow());
        gameEntity.setCl(request.getColumn());
        gameEntity.setCurrentPlayerId(request.getPlayer1Id());
        gameEntity.setBoardState("_".repeat(request.getRow() * request.getColumn()));
        gameEntity.setIsGameOver(Boolean.FALSE);

        return gameRepository
                .save(gameEntity)
                .map(GameMapper.INSTANCE::entityToResponse);
    }

    @Override
    public Mono<GameResponse> makeMove(MakeMoveRequest request) {
        return gameRepository.findById(request.getGameId())
                .flatMap(gameEntity -> {
                    if (gameEntity.getIsGameOver()) {
                        return Mono.error(new InvalidBodyException("Game is already over!"));
                    }

                    if (!gameEntity.getCurrentPlayerId().equals(request.getPlayerId())) {
                        return Mono.error(new InvalidBodyException("It's not your turn!"));
                    }

                    if (!gameHelperService.isValidMove(gameEntity, request.getRow(), request.getColumn())) {
                        return Mono.error(new InvalidBodyException("Invalid move!"));
                    }

                    Character symbol = request.getPlayerId().equals(gameEntity.getPlayer1Id()) ? 'X' : 'O';

                    String updatedBoard = gameHelperService.updateBoard(gameEntity.getBoardState(), request.getRow(), request.getColumn(), gameEntity.getRw(), symbol);

                    if (gameHelperService.checkWinner(updatedBoard, request.getRow(), request.getColumn(), gameEntity.getCl(), gameEntity.getRw(), symbol)) {
                        gameEntity.setIsGameOver(true);
                        return gameRepository.save(gameEntity);
                    }

                    if (gameHelperService.isBoardFull(updatedBoard)) {
                        gameEntity.setIsGameOver(true);
                        return gameRepository.save(gameEntity);
                    }

                    UUID nextPlayer = gameEntity.getPlayer1Id().equals(request.getPlayerId()) ? gameEntity.getPlayer2Id() : gameEntity.getPlayer1Id();
                    gameEntity.setBoardState(updatedBoard);
                    gameEntity.setCurrentPlayerId(nextPlayer);

                    MoveEntity moveEntity = new MoveEntity();
                    moveEntity.setId(UUID.randomUUID());
                    moveEntity.setIdGame(gameEntity.getId());
                    moveEntity.setIdPlayer(request.getPlayerId());
                    moveEntity.setRw(request.getRow());
                    moveEntity.setCl(request.getColumn());
                    moveEntity.setSymbol(symbol);

                    return moveRepository
                            .save(moveEntity)
                            .then(gameRepository.save(gameEntity));
                })
                .map(GameMapper.INSTANCE::entityToResponse);
    }

}
