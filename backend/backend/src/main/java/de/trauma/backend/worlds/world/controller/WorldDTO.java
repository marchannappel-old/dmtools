package de.trauma.backend.worlds.world.controller;

import de.trauma.backend.worlds.articles.article.controller.ArticleDTO;
import de.trauma.backend.worlds.world.domain.World;

import java.util.List;

public class WorldDTO {
    private final Long id;
    private final String name;
    private final String system;
    private List<ArticleDTO> articles;

    public WorldDTO(World world) {
        this.id = world.getId();
        this.name = world.getName();
        this.system = world.getSystem();
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
}
