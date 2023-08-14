package de.trauma.backend.worlds.articles.article.repository;

import de.trauma.backend.worlds.articles.article.domain.Article;
import de.trauma.backend.worlds.articles.articletype.repository.ArticleTypeEntity;
import de.trauma.backend.worlds.articles.category.repository.CategoryEntity;
import de.trauma.backend.worlds.world.repository.WorldEntity;

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
    private String pronunciation;

    @Column
    private String content;

    @Column
    private String image;

    @ManyToOne
    @JoinColumn(name = "world_id")
    private WorldEntity world;

    @ManyToMany
    @JoinTable(
            name = "article_type",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "articletype_id")
    )
    private List<ArticleTypeEntity> types;

    @ManyToMany
    @JoinTable(
            name = "article_category",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryEntity> categories;

    public ArticleEntity() {
    }

    public ArticleEntity(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.pronunciation = article.getPronunciation();
        this.content = article.getContent();
        this.image = article.getImage();
        this.world = new WorldEntity(article.getWorld());
        this.types.add(new ArticleTypeEntity(article.getType()));
        this.categories = article.getCategories().stream().map(CategoryEntity::new).toList();
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

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
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

    public WorldEntity getWorld() {
        return world;
    }

    public void setWorld(WorldEntity world) {
        this.world = world;
    }

    public List<ArticleTypeEntity> getType() {
        return types;
    }

    public void setType(List<ArticleTypeEntity> type) {
        this.types = type;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }
}
