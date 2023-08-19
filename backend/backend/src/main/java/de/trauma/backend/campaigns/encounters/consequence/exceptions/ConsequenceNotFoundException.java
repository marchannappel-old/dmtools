package de.trauma.backend.campaigns.encounters.consequence.exceptions;

public class ConsequenceNotFoundException extends RuntimeException {
    public ConsequenceNotFoundException(String message) {
        super(message);
    }
}
