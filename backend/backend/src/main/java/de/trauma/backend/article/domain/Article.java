package de.trauma.backend.article.domain;

import de.trauma.backend.article.repository.ArticleEntity;

import java.util.List;

public class Article {
    private Long id;
    private String title;
    private String pronunciation;
    private String content;
    private String image;
    private ArticleType type;
    private List<Category> categories;

    public Article(Long id, String title, String pronunciation, String content, String image, ArticleType type) {
        this.id = id;
        this.title = title;
        this.pronunciation = pronunciation;
        this.content = content;
        this.image = image;
        this.type = type;
    }

    public Article(ArticleEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.pronunciation = entity.getPronunciation();
        this.content = entity.getContent();
        this.image = entity.getImage();
        this.type = new ArticleType(entity.getType());
        this.categories = entity.getCategories().stream().map(Category::new).toList();
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

    public ArticleType getType() {
        return type;
    }

    public void setType(ArticleType type) {
        this.type = type;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
