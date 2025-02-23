package com.testing.tic_tac_toe.domain.entity;

import com.testing.tic_tac_toe.domain.common.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
@Table(name = "t_game")
public class GameEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -7116128709772330246L;

    @Id
    private UUID id;
    private UUID player1Id;
    private UUID player2Id;
    private Integer rw;
    private Integer cl;
    private String boardState;
    private UUID currentPlayerId;
    private Boolean isGameOver;

}
