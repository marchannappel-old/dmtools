package de.trauma.backend.campaigns.campaign.domain;

import de.trauma.backend.campaigns.campaign.repository.CampaignEntity;
import de.trauma.backend.worlds.world.domain.World;

import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public List<World> getWorlds() {
        return worlds;
    }

    public void setWorlds(List<World> worlds) {
        this.worlds = worlds;
    }
}
