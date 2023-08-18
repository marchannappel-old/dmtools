package de.trauma.backend.worlds.articles.articletype.domain;

import de.trauma.backend.worlds.articles.articletype.repository.ArticleTypeEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleType {
    private Long id;
    private String name;

    // TODO: Check this mapping for errors
    public ArticleType(ArticleTypeEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
