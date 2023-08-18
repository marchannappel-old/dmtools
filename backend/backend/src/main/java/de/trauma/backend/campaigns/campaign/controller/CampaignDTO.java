package de.trauma.backend.campaigns.campaign.controller;

import de.trauma.backend.campaigns.campaign.domain.Campaign;
import de.trauma.backend.worlds.world.controller.WorldDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class CampaignDTO {
    private final Long id;
    private final String name;
    private final String excerpt;
    private final String introduction;
    private final String cover;
    private final List<WorldDTO> worlds;

    public CampaignDTO(Campaign campaign) {
        this.id = campaign.getId();
        this.name = campaign.getName();
        this.excerpt = campaign.getExcerpt();
        this.introduction = campaign.getIntroduction();
        this.cover = campaign.getCover();
        this.worlds = campaign.getWorlds().stream().map(WorldDTO::new).toList();
    }
}
