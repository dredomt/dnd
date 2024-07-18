package dev.dredomt.moria.dnd.dto;

import dev.dredomt.moria.dnd.model.Character;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {PlayerMapper.class, CampaignMapper.class})

public interface CharacterMapper {
    CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    @Mapping(source = "playerId", target = "player.id")
    @Mapping(source = "campaignId", target = "campaign.id")
    Character toEntity(CharacterDTO characterDTO);

    @Mapping(source = "player.id", target = "playerId")
    @Mapping(source = "campaign.id", target = "campaignId")
    CharacterDTO toDto(Character character);
}