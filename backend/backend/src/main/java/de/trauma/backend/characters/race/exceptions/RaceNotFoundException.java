package de.trauma.backend.characters.race.exceptions;

public class RaceNotFoundException extends RuntimeException {
    public RaceNotFoundException(String message) {
        super(message);
    }
}
