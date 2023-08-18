package de.trauma.backend.characters.charactertype.exception;

public class CharacterTypeNotFoundException extends RuntimeException {
    public CharacterTypeNotFoundException(String message) {
        super(message);
    }
}
