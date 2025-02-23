package com.testing.tic_tac_toe.mapper;

import com.testing.tic_tac_toe.domain.entity.PlayerEntity;
import com.testing.tic_tac_toe.payload.response.PlayerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    PlayerResponse entityToResponse(PlayerEntity playerEntity);

}
