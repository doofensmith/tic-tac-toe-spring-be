package com.testing.tic_tac_toe.service;

import com.testing.tic_tac_toe.payload.request.CreatePlayerRequest;
import com.testing.tic_tac_toe.payload.response.PlayerResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface PlayerService {

    Mono<PlayerResponse> createPlayer(CreatePlayerRequest request);

}
