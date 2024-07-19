package dev.dredomt.moria.dnd.service;

import dev.dredomt.moria.dnd.Exceptions.CampaignNotFoundException;
import dev.dredomt.moria.dnd.dto.CampaignDTO;
import dev.dredomt.moria.dnd.dto.CampaignMapper;
import dev.dredomt.moria.dnd.model.Campaign;
import dev.dredomt.moria.dnd.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private CampaignMapper campaignMapper;

    public List<CampaignDTO> getAllCampaigns() {
        List<Campaign> campaigns = campaignRepository.findAll();
        return campaigns.stream()
                .map(campaignMapper::toDto)
                .collect(Collectors.toList());
    }

    public CampaignDTO getCampaignById(Integer id) {
        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow(CampaignNotFoundException::new);
        return campaignMapper.toDto(campaign);
    }

    public CampaignDTO createCampaign(CampaignDTO campaignDTO) {
        Campaign campaign = campaignMapper.toEntity(campaignDTO);
        campaign = campaignRepository.save(campaign);
        return campaignMapper.toDto(campaign);
    }

    public CampaignDTO updateCampaign(Integer id, CampaignDTO campaignDTO) {
        Campaign existingCampaign = campaignRepository.findById(id)
                .orElseThrow(CampaignNotFoundException::new);
        existingCampaign.setName(campaignDTO.getName());
        existingCampaign.setDescription(campaignDTO.getDescription());
        existingCampaign.setDungeonMaster(campaignDTO.getDungeonMaster());
        existingCampaign.setStatus(campaignDTO.getStatus());
        // Update other fields as needed

        Campaign updatedCampaign = campaignRepository.save(existingCampaign);
        return campaignMapper.toDto(updatedCampaign);
    }

    public void deleteCampaign(Integer id) {
        Campaign campaign = campaignRepository.findById(id)
                        .orElseThrow(CampaignNotFoundException::new);
        campaignRepository.deleteById(id);
    }
}
