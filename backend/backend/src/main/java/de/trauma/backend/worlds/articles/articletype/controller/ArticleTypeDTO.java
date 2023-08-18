package de.trauma.backend.worlds.articles.articletype.controller;

import de.trauma.backend.worlds.articles.articletype.domain.ArticleType;
import lombok.Getter;

@Getter
public class ArticleTypeDTO {
    private final Long id;
    private final String name;

    // TODO: Check this mapping for errors!
    public ArticleTypeDTO(ArticleType articleType) {
        this.id = articleType.getId();
        this.name = articleType.getName();
    }
}
