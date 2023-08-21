package de.trauma.backend.characters.items.itemType.exceptions;

public class ItemTypeNotFoundException extends RuntimeException {
    public ItemTypeNotFoundException(String message) {
        super(message);
    }
}
