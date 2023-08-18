package de.trauma.backend.worlds.world.controller;

import de.trauma.backend.campaigns.campaign.controller.CampaignDTO;
import de.trauma.backend.worlds.articles.article.controller.ArticleDTO;
import de.trauma.backend.worlds.world.domain.World;

import java.util.List;

public class WorldDTO {
    private final Long id;
    private final String name;
    private final String system;
    private final List<ArticleDTO> articles;
    private final List<CampaignDTO> campaigns;

    public WorldDTO(World world) {
        this.id = world.getId();
        this.name = world.getName();
        this.system = world.getSystem();
        this.articles = world.getArticles().stream().map(ArticleDTO::new).toList();
        this.campaigns = world.getCampaigns().stream().map(CampaignDTO::new).toList();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSystem() {
        return system;
    }

    public List<ArticleDTO> getArticles() {
        return articles;
    }

    public List<CampaignDTO> getCampaigns() {
        return campaigns;
    }
}
