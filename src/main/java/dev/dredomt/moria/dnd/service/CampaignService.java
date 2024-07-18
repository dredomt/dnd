package dev.dredomt.moria.dnd.service;

import dev.dredomt.moria.dnd.Exceptions.CampaignNotFoundException;
import dev.dredomt.moria.dnd.model.Campaign;
import dev.dredomt.moria.dnd.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;

    public List<Campaign> getAllCampaigns() {
        return (campaignRepository.findAll());
    }

    public Campaign getCampaignById(Integer id) {
        Optional<Campaign> campaign = campaignRepository.findById(id);
        if(campaign.isEmpty()) {
            throw new CampaignNotFoundException();
        }
        return campaign.get();
    }

    public Campaign saveCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public void deleteCampaign(Integer id) {
        campaignRepository.deleteById(id);
    }
}
