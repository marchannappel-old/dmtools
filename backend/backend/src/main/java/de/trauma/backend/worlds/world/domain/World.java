package de.trauma.backend.worlds.world.domain;

import de.trauma.backend.worlds.articles.article.domain.Article;
import de.trauma.backend.worlds.world.repository.WorldEntity;

import java.util.List;

public class World {
    private Long id;
    private String name;
    private String system;
    private List<Article> articles;

    public World(WorldEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.system = entity.getSystem();
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
