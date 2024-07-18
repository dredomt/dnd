package dev.dredomt.moria.dnd.dto;

import dev.dredomt.moria.dnd.model.Campaign;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = CharacterMapper.class)
public interface CampaignMapper {
    CampaignMapper INSTANCE = Mappers.getMapper(CampaignMapper.class);
    CampaignDTO toDto(Campaign campaign);
    Campaign toEntity(CampaignDTO campaignDTO);
}
