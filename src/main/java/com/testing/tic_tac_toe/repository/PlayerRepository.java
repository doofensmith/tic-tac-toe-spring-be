package com.testing.tic_tac_toe.repository;

import com.testing.tic_tac_toe.domain.entity.PlayerEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerRepository extends R2dbcRepository<PlayerEntity, UUID> {
}
