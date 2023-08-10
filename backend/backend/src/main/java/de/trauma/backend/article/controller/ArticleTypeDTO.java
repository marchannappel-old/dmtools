package de.trauma.backend.article.controller;

import de.trauma.backend.article.domain.ArticleType;

public class ArticleTypeDTO {
    private final Long id;

    private final String name;

    public ArticleTypeDTO(ArticleType articleType) {
        this.id = articleType.getId();
        this.name = articleType.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
