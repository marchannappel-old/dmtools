package de.trauma.backend.characters.defense.exceptions;

public class DefenseNotFoundException extends RuntimeException {
    public DefenseNotFoundException(String message) {
        super(message);
    }
}
