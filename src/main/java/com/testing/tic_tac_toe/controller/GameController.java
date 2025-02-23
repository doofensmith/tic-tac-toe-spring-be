package com.testing.tic_tac_toe.controller;

import com.testing.tic_tac_toe.domain.common.BaseResponse;
import com.testing.tic_tac_toe.mapper.ResponseMapper;
import com.testing.tic_tac_toe.payload.request.CreateGameRequest;
import com.testing.tic_tac_toe.payload.request.MakeMoveRequest;
import com.testing.tic_tac_toe.payload.response.GameResponse;
import com.testing.tic_tac_toe.service.GameService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Tag(name = "Game")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/game")
public class GameController {

    private final GameService gameService;

    @PostMapping(value = "/create")
    public Mono<ResponseEntity<BaseResponse<GameResponse>>> createGame(@RequestBody CreateGameRequest request) {
        return gameService
                .createGame(request)
                .map(gameResponse -> ResponseMapper.map(HttpStatus.OK, gameResponse));
    }

    @PostMapping(value = "/move")
    public Mono<ResponseEntity<BaseResponse<GameResponse>>> makeMove(@RequestBody MakeMoveRequest request) {
        return gameService
                .makeMove(request)
                .map(gameResponse -> ResponseMapper.map(HttpStatus.OK, gameResponse));
    }

}
