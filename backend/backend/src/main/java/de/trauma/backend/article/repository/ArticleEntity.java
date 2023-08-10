package de.trauma.backend.article.repository;

import de.trauma.backend.article.domain.Article;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String image;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ArticleTypeEntity type;

    @ManyToMany
    @JoinTable(
            name = "article_category",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryEntity> categories;

    public ArticleEntity() {
    }

    public ArticleEntity(Long id, String title, String content, String image, ArticleTypeEntity type) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.type = type;
    }

    public ArticleEntity(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.image = article.getImage();
        this.type = article.getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArticleTypeEntity getType() {
        return type;
    }

    public void setType(ArticleTypeEntity type) {
        this.type = type;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }
}
