package com.testing.tic_tac_toe.mapper;

import com.testing.tic_tac_toe.domain.entity.GameEntity;
import com.testing.tic_tac_toe.payload.response.GameResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameMapper {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "player1Id", source = "player1Id")
    @Mapping(target = "player2Id", source = "player2Id")
    @Mapping(target = "row", source = "rw")
    @Mapping(target = "column", source = "cl")
    @Mapping(target = "boardState", source = "boardState")
    @Mapping(target = "currentPlayerId", source = "currentPlayerId")
    @Mapping(target = "isGameOver", source = "isGameOver")
    GameResponse entityToResponse(GameEntity gameEntity);

}
