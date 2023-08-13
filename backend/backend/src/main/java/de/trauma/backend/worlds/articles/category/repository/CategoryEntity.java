package de.trauma.backend.worlds.articles.category.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.trauma.backend.worlds.articles.article.repository.ArticleEntity;
import de.trauma.backend.worlds.articles.category.domain.Category;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "categories")
    @JsonBackReference
    private List<ArticleEntity> articles;

    public CategoryEntity() {
    }

    public CategoryEntity(Category category) {
        this.id = category.getId();
        this.name = category.getName();
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
