package dev.dredomt.moria.dnd.controller;

import dev.dredomt.moria.dnd.model.Campaign;
import dev.dredomt.moria.dnd.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/dnd/campaigns")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @GetMapping("")
    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/{id}")
    public Campaign getCampaignById(@PathVariable Integer id) {
        return campaignService.getCampaignById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Campaign createCampaign(@Validated @RequestBody Campaign campaign) {
        return campaignService.saveCampaign(campaign);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Campaign updateCampaign(@Validated @RequestBody Campaign campaign, @PathVariable Integer id) {
        campaign.setId(id);
        return campaignService.saveCampaign(campaign);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCampaign(@PathVariable Integer id) {
        campaignService.deleteCampaign(id);
    }
}
