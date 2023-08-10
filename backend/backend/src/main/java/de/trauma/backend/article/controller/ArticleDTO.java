package de.trauma.backend.article.controller;

import de.trauma.backend.article.domain.Article;
import de.trauma.backend.article.domain.ArticleType;
import de.trauma.backend.article.domain.Category;

import java.util.List;

public class ArticleDTO {
    private final Long id;
    private final String title;
    private final String pronunciation;
    private final String content;
    private final String image;
    private final ArticleType type;
    private final List<Category> categories;

    public ArticleDTO(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.pronunciation = article.getPronunciation();
        this.content = article.getContent();
        this.image = article.getImage();
        this.type = article.getType();
        this.categories = article.getCategories();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public ArticleType getType() {
        return type;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
