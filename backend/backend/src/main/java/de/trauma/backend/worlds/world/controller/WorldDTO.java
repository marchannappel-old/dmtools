package de.trauma.backend.worlds.world.controller;

import de.trauma.backend.campaigns.campaign.controller.CampaignDTO;
import de.trauma.backend.worlds.articles.article.controller.ArticleDTO;
import de.trauma.backend.worlds.meta.controller.MetaDTO;
import de.trauma.backend.worlds.settings.controller.SettingsDTO;
import de.trauma.backend.worlds.world.domain.World;
import lombok.Getter;

import java.util.List;

@Getter
public class WorldDTO {
    private final Long id;
    private final String name;
    private final String system;
    private final List<ArticleDTO> articles;
    private final List<CampaignDTO> campaigns;
    private final MetaDTO meta;
    private final SettingsDTO settings;

    public WorldDTO(World world) {
        this.id = world.getId();
        this.name = world.getName();
        this.system = world.getSystem();
        this.articles = world.getArticles().stream().map(ArticleDTO::new).toList();
        this.campaigns = world.getCampaigns().stream().map(CampaignDTO::new).toList();
        this.meta = new MetaDTO(world.getMeta());
        this.settings = new SettingsDTO(world.getSettings());
    }
}
