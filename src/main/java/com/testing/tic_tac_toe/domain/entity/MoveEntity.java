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
@Table(name = "t_move")
public class MoveEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 7737182045642265336L;

    @Id
    private UUID id;
    private UUID idGame;
    private UUID idPlayer;
    private Integer rw;
    private Integer cl;
    private Character symbol;

}
