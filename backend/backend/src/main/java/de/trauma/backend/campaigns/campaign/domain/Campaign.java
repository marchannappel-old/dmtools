package de.trauma.backend.campaigns.campaign.domain;

import de.trauma.backend.campaigns.campaign.repository.CampaignEntity;
import de.trauma.backend.worlds.world.domain.World;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Campaign {
    private Long id;
    private String name;
    private String excerpt;
    private String introduction;
    private String cover;
    private List<World> worlds;

    public Campaign(CampaignEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.excerpt = entity.getExcerpt();
        this.introduction = entity.getIntroduction();
        this.cover = entity.getCover();
        this.worlds = entity.getWorlds().stream().map(World::new).toList();
    }
}
