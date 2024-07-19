package dev.dredomt.moria.dnd.service;

import dev.dredomt.moria.dnd.Exceptions.CampaignNotFoundException;
import dev.dredomt.moria.dnd.dto.CampaignDTO;
import dev.dredomt.moria.dnd.dto.CampaignMapper;
import dev.dredomt.moria.dnd.model.Campaign;
import dev.dredomt.moria.dnd.repository.CampaignRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CampaignServiceTest {


    @Mock
    private CampaignRepository campaignRepository;
    @Mock
    private CampaignMapper campaignMapper;
    @InjectMocks
    private CampaignService campaignService;

    private Campaign campaign;
    private Campaign campaign2;
    private CampaignDTO campaignDTO;
    private CampaignDTO campaignDTO2;

    @BeforeEach
    public void setup() {
        campaign = new Campaign();
        campaign2 = new Campaign();
        campaign.setId(1);
        campaign2.setId(2);
        campaign.setName("Campaign 1");
        campaign2.setName("Campaign 2");
        campaign.setDescription("Description 1");
        campaign2.setDescription("Description 2");
        campaign.setDungeonMaster("Dungeon Master 1");
        campaign2.setDungeonMaster("Dungeon Master 2");
        campaign.setStatus("Status 1");
        campaign2.setStatus("Status 2");
        campaignDTO = new CampaignDTO();
        campaignDTO2 = new CampaignDTO();
        campaignDTO.setId(1);
        campaignDTO2.setId(2);
        campaignDTO.setName("Campaign 1");
        campaignDTO2.setName("Campaign 2");
        campaignDTO.setDescription("Description 1");
        campaignDTO2.setDescription("Description 2");
        campaignDTO.setDungeonMaster("Dungeon Master 1");
        campaignDTO2.setDungeonMaster("Dungeon Master 2");
        campaignDTO.setStatus("Status 1");
        campaignDTO2.setStatus("Status 2");
    }
    @Test
    public void testCreateCampaign() {
        when(campaignMapper.toEntity(campaignDTO)).thenReturn(campaign);
        when(campaignRepository.save(campaign)).thenReturn(campaign);
        when(campaignMapper.toDto(campaign)).thenReturn(campaignDTO);

        CampaignDTO createdCampaign = campaignService.createCampaign(campaignDTO);

        assertNotNull(createdCampaign);
        assertEquals(campaignDTO, createdCampaign);
        verify(campaignRepository, times(1)).save(campaign);
    }

    @Test
    public void testUpdateCampaign() {
        when(campaignRepository.findById(campaignDTO.getId())).thenReturn(Optional.of(campaign));
        when(campaignRepository.save(campaign)).thenReturn(campaign);
        when(campaignMapper.toDto(campaign)).thenReturn(campaignDTO);

        CampaignDTO updatedCampaign = campaignService.updateCampaign(campaignDTO.getId(), campaignDTO);

        assertNotNull(updatedCampaign);
        assertEquals(campaignDTO, updatedCampaign);
        verify(campaignRepository, times(1)).save(campaign);
    }


    @Test
    public void testGetCampaignById() {
        when(campaignRepository.findById(campaignDTO.getId())).thenReturn(Optional.of(campaign));
        when(campaignMapper.toDto(campaign)).thenReturn(campaignDTO);

        CampaignDTO foundCampaign = campaignService.getCampaignById(campaignDTO.getId());

        assertNotNull(foundCampaign);
        assertEquals(campaignDTO, foundCampaign);
    }

    @Test
    public void testGetCampaignByIdNotFound() {
        when(campaignRepository.findById(campaignDTO.getId())).thenReturn(Optional.empty());
        assertThrows(CampaignNotFoundException.class, () -> campaignService.getCampaignById(campaignDTO.getId()));
        verify(campaignRepository, times(1)).findById(campaignDTO.getId());
    }

    @Test
    public void testGetAllCampaigns() {
        List<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaign);
        campaigns.add(campaign2);
        when(campaignRepository.findAll()).thenReturn(campaigns);

        List<CampaignDTO> campaignDTOs = campaignService.getAllCampaigns();

        assertEquals(2, campaignDTOs.size());
        verify(campaignRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteCampaign() {
        when(campaignRepository.findById(campaignDTO.getId())).thenReturn(Optional.of(campaign));
        campaignService.deleteCampaign(campaignDTO.getId());
        verify(campaignRepository, times(1)).deleteById(campaignDTO.getId());
    }

    @Test
    public void testDeleteCampaignNotFound() {
        when(campaignRepository.findById(campaignDTO.getId())).thenReturn(Optional.empty());
        assertThrows(CampaignNotFoundException.class, () -> campaignService.deleteCampaign(campaignDTO.getId()));
        verify(campaignRepository, times(0)).deleteById(campaignDTO.getId());
    }
}