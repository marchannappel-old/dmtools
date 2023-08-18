package de.trauma.backend.worlds.world.repository;

import de.trauma.backend.campaigns.campaign.repository.CampaignEntity;
import de.trauma.backend.worlds.articles.article.repository.ArticleEntity;
import de.trauma.backend.worlds.world.domain.World;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class WorldEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String system;

    @OneToMany(mappedBy = "world")
    private List<ArticleEntity> articles;

    @ManyToMany
    @JoinTable(
            name = "world_campaign",
            joinColumns = @JoinColumn(name = "world_id"),
            inverseJoinColumns = @JoinColumn(name = "campaign_id")
    )
    private List<CampaignEntity> campaigns;

    public WorldEntity() {
    }

    public WorldEntity(World world) {
        this.id = world.getId();
        this.name = world.getName();
        this.system = world.getSystem();
        this.articles = world.getArticles().stream().map(ArticleEntity::new).toList();
        this.campaigns = world.getCampaigns().stream().map(CampaignEntity::new).toList();
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

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public List<ArticleEntity> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleEntity> articles) {
        this.articles = articles;
    }

    public List<CampaignEntity> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<CampaignEntity> campaigns) {
        this.campaigns = campaigns;
    }
}
