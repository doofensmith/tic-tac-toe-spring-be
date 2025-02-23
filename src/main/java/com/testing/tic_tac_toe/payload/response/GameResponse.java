package com.testing.tic_tac_toe.payload.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GameResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 2455101817174812798L;

    private UUID id;
    private UUID player1Id;
    private UUID player2Id;
    private Integer row;
    private Integer column;
    private String boardState;
    private UUID currentPlayerId;
    private Boolean isGameOver;

}
