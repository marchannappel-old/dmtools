package de.trauma.backend.worldCreation.article.exceptions;

public class ArticleTypeNotFoundException extends RuntimeException {
    public ArticleTypeNotFoundException(String message) {
        super(message);
    }
}
