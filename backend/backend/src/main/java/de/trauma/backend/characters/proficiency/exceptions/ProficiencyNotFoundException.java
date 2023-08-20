package de.trauma.backend.characters.proficiency.exceptions;

public class ProficiencyNotFoundException extends RuntimeException {
    public ProficiencyNotFoundException(String message) {
        super(message);
    }
}
