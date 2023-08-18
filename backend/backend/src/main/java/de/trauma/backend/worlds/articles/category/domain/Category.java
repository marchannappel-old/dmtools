package de.trauma.backend.worlds.articles.category.domain;

import de.trauma.backend.worlds.articles.category.repository.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private Long id;
    private String name;

    public Category(CategoryEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
