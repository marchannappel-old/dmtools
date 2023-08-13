package de.trauma.backend.campaigns.encounters.obstacle.exceptions;

public class ObstacleNotFoundException extends RuntimeException {
    public ObstacleNotFoundException(String message) {
        super(message);
    }
}
