package de.trauma.backend.campaigns.campaign.controller;

import de.trauma.backend.campaigns.campaign.domain.Campaign;
import de.trauma.backend.campaigns.campaign.service.CampaignService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {
    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping
    public List<CampaignDTO> list() {
        return this.campaignService.findAllCampaigns()
                .stream()
                .map(CampaignDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public CampaignDTO read(@PathVariable Long id) {
        return this.campaignService.findCampaignById(id)
                .map(CampaignDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public CampaignDTO create(@RequestBody Campaign campaign) {
        return new CampaignDTO(this.campaignService.createCampaign(campaign));
    }

    @PutMapping("/{id}")
    public CampaignDTO update(@PathVariable Long id, @RequestBody Campaign campaign) {
        return new CampaignDTO(this.campaignService.updateCampaign(id, campaign));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.campaignService.deleteCampaign(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
