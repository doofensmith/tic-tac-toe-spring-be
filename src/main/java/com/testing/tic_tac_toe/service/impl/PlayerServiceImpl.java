package com.testing.tic_tac_toe.service.impl;

import com.testing.tic_tac_toe.domain.entity.PlayerEntity;
import com.testing.tic_tac_toe.mapper.PlayerMapper;
import com.testing.tic_tac_toe.payload.request.CreatePlayerRequest;
import com.testing.tic_tac_toe.payload.response.PlayerResponse;
import com.testing.tic_tac_toe.repository.PlayerRepository;
import com.testing.tic_tac_toe.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public Mono<PlayerResponse> createPlayer(CreatePlayerRequest request) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(UUID.randomUUID());
        playerEntity.setName(request.getName());

        return playerRepository
                .save(playerEntity)
                .map(PlayerMapper.INSTANCE::entityToResponse);
    }
}
