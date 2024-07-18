package dev.dredomt.moria.dnd.controller;

import dev.dredomt.moria.dnd.dto.CampaignDTO;
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
    public List<CampaignDTO> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/{id}")
    public CampaignDTO getCampaignById(@PathVariable Integer id) {

        CampaignDTO campaignDTO = campaignService.getCampaignById(id);
        return campaignService.getCampaignById(id);
    }

    @PostMapping("")
    public CampaignDTO createCampaign(@RequestBody CampaignDTO campaignDTO) {
        return campaignService.createCampaign(campaignDTO);
    }

    @PutMapping("/{id}")
    public CampaignDTO updateCampaign(@PathVariable Integer id, @RequestBody CampaignDTO campaignDTO) {
        return campaignService.updateCampaign(id, campaignDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCampaign(@PathVariable Integer id) {
        campaignService.deleteCampaign(id);
    }
}
