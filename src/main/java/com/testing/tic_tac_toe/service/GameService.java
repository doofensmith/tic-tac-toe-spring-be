package com.testing.tic_tac_toe.service;

import com.testing.tic_tac_toe.payload.request.CreateGameRequest;
import com.testing.tic_tac_toe.payload.request.MakeMoveRequest;
import com.testing.tic_tac_toe.payload.response.GameResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface GameService {

    Mono<GameResponse> createGame(CreateGameRequest request);

    Mono<GameResponse> makeMove(MakeMoveRequest request);

}
