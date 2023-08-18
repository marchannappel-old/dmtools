package de.trauma.backend.worlds.world.domain;

import de.trauma.backend.campaigns.campaign.domain.Campaign;
import de.trauma.backend.worlds.articles.article.domain.Article;
import de.trauma.backend.worlds.meta.domain.Meta;
import de.trauma.backend.worlds.world.repository.WorldEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class World {
    private Long id;
    private String name;
    private String system;
    private List<Article> articles;
    private List<Campaign> campaigns;
    private Meta meta;

    public World(WorldEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.system = entity.getSystem();
        this.articles = entity.getArticles().stream().map(Article::new).toList();
        this.campaigns = entity.getCampaigns().stream().map(Campaign::new).toList();
        this.meta = new Meta(entity.getMeta());
    }
}
