package de.trauma.backend.worlds.articles.category.domain;

import de.trauma.backend.worlds.articles.category.repository.CategoryEntity;

public class Category {
    private Long id;
    private String name;

    public Category(CategoryEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
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
