package de.trauma.backend.article.controller;

import de.trauma.backend.article.domain.Category;

public class CategoryDTO {
    private final Long id;
    private final String name;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
