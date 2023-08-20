package de.trauma.backend.characters.ability.exceptions;

public class AbilityNotFoundException extends RuntimeException {
    public AbilityNotFoundException(String message) {
        super(message);
    }
}
