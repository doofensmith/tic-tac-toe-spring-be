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
@Table(name = "t_player")
public class PlayerEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -5217453215154202443L;

    @Id
    private UUID id;
    private String name;

}
