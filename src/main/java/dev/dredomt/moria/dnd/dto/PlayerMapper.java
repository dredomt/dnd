package dev.dredomt.moria.dnd.dto;

import dev.dredomt.moria.dnd.model.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    PlayerDTO toDto(Player player);
    Player toEntity(PlayerDTO playerDTO);
}