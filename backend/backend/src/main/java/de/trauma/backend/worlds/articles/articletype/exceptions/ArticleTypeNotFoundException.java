package de.trauma.backend.worlds.articles.articletype.exceptions;

public class ArticleTypeNotFoundException extends RuntimeException {
    public ArticleTypeNotFoundException(String message) {
        super(message);
    }
}
