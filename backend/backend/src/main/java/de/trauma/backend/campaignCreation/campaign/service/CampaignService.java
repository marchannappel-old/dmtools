package de.trauma.backend.campaignCreation.campaign.service;

import de.trauma.backend.campaignCreation.campaign.repository.CampaignRepository;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {
    private final CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }
}
