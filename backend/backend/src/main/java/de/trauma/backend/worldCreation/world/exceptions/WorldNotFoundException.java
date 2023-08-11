package de.trauma.backend.worldCreation.world.exceptions;

public class WorldNotFoundException extends RuntimeException {
    public WorldNotFoundException(String message) {
        super(message);
    }
}
