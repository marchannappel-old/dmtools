package de.trauma.backend.campaigns.monsters.difficulty.exceptions;

public class DifficultyNotFoundException extends RuntimeException {
    public DifficultyNotFoundException(String message) {
        super(message);
    }
}
