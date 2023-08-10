package de.trauma.backend.worldCreation.article.domain;

import de.trauma.backend.worldCreation.article.repository.ArticleTypeEntity;

public class ArticleType {
    private Long id;

    private String name;

    public ArticleType(ArticleTypeEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public ArticleType(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
