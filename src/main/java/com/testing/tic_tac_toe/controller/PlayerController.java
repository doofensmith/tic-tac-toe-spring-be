package com.testing.tic_tac_toe.controller;

import com.testing.tic_tac_toe.domain.common.BaseResponse;
import com.testing.tic_tac_toe.mapper.ResponseMapper;
import com.testing.tic_tac_toe.payload.request.CreatePlayerRequest;
import com.testing.tic_tac_toe.payload.response.PlayerResponse;
import com.testing.tic_tac_toe.service.PlayerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Tag(name = "Player")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping(value = "/create")
    public Mono<ResponseEntity<BaseResponse<PlayerResponse>>> createPlayer(@RequestBody CreatePlayerRequest request) {
        return playerService
                .createPlayer(request)
                .map(gameResponse -> ResponseMapper.map(HttpStatus.OK, gameResponse));
    }

}

