package de.trauma.backend.characters.condition.exceptions;

public class ConditionNotFoundException extends RuntimeException {
    public ConditionNotFoundException(String message) {
        super(message);
    }
}
