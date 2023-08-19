package de.trauma.backend.worlds.articles.category.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.trauma.backend.worlds.articles.article.repository.ArticleEntity;
import de.trauma.backend.worlds.articles.category.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "categories")
    @JsonBackReference
    private List<ArticleEntity> articles;

    public CategoryEntity(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
