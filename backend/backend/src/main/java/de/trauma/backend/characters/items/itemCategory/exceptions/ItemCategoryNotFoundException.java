package de.trauma.backend.characters.items.itemCategory.exceptions;

public class ItemCategoryNotFoundException extends RuntimeException {
    public ItemCategoryNotFoundException(String message) {
        super(message);
    }
}
