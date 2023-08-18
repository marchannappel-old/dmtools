package de.trauma.backend.worlds.articles.category.controller;

import de.trauma.backend.worlds.articles.category.domain.Category;
import lombok.Getter;

@Getter
public class CategoryDTO {
    private final Long id;
    private final String name;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
