package de.trauma.backend.campaigns.campaign.service;

import de.trauma.backend.campaigns.campaign.domain.Campaign;
import de.trauma.backend.campaigns.campaign.exceptions.CampaignNotFoundException;
import de.trauma.backend.campaigns.campaign.repository.CampaignEntity;
import de.trauma.backend.campaigns.campaign.repository.CampaignRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {
    private final CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public List<Campaign> findAllCampaigns() {
        return this.campaignRepository.findAll()
                .stream()
                .map(Campaign::new)
                .toList();
    }

    public Optional<Campaign> findCampaignById(Long id) {
        return this.campaignRepository.findById(id)
                .map(Campaign::new);
    }

    public Campaign createCampaign(Campaign campaign) {
        return new Campaign(this.campaignRepository.save(new CampaignEntity(campaign)));
    }

    public Campaign updateCampaign(Long id, Campaign campaign) {
        Optional<Campaign> existingCampaign = this.campaignRepository.findById(id)
                .map(Campaign::new);

        if (existingCampaign.isPresent()) {
            Campaign updatedCampaign = existingCampaign.get();
            updatedCampaign.setId(campaign.getId());
            updatedCampaign.setName(campaign.getName());
            updatedCampaign.setCover(campaign.getCover());
            updatedCampaign.setIntroduction(campaign.getIntroduction());
            updatedCampaign.setExcerpt(campaign.getExcerpt());
            updatedCampaign.setWorlds(campaign.getWorlds());

            return new Campaign(this.campaignRepository.save(new CampaignEntity(updatedCampaign)));
        }
        else {
            throw new CampaignNotFoundException("Campaign could not found with id: " + id);
        }
    }

    public void deleteCampaign(Long id) {
        this.campaignRepository.deleteById(id);
    }
}
