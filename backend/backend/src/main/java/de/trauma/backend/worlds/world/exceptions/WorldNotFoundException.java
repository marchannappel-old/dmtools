package de.trauma.backend.worlds.world.exceptions;

public class WorldNotFoundException extends RuntimeException {
    public WorldNotFoundException(String message) {
        super(message);
    }
}
