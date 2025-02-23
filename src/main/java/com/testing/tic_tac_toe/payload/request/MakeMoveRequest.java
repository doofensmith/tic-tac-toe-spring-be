package com.testing.tic_tac_toe.payload.request;

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
public class MakeMoveRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -7925131287217158138L;

    private UUID gameId;
    private UUID playerId;
    private Integer row;
    private Integer column;

}
