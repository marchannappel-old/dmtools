package de.trauma.backend.campaigns.monsterCreation.difficulty.exceptions;

public class DifficultyNotFoundException extends RuntimeException {
    public DifficultyNotFoundException(String message) {
        super(message);
    }
}
