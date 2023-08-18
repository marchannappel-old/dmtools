package de.trauma.backend.campaigns.campaign.repository;

import de.trauma.backend.campaigns.campaign.domain.Campaign;
import de.trauma.backend.worlds.world.repository.WorldEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class CampaignEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String excerpt;

    @Column
    private String introduction;

    /**
     * TODO: Replace with many to many relation to Image later on
     */
    @Column
    private String cover;

    @ManyToMany(mappedBy = "campaigns")
    private List<WorldEntity> worlds;

    public CampaignEntity() {
    }

    public CampaignEntity(Campaign campaign) {
        this.id = campaign.getId();
        this.name = campaign.getName();
        this.excerpt = campaign.getExcerpt();
        this.introduction = campaign.getIntroduction();
        this.cover = campaign.getCover();
        this.worlds = campaign.getWorlds().stream().map(WorldEntity::new).toList();
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

    public List<WorldEntity> getWorlds() {
        return worlds;
    }

    public void setWorlds(List<WorldEntity> worlds) {
        this.worlds = worlds;
    }
}
