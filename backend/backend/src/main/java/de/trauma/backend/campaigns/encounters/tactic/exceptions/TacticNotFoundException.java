package de.trauma.backend.campaigns.encounters.tactic.exceptions;

public class TacticNotFoundException extends RuntimeException {
    public TacticNotFoundException(String message) {
        super(message);
    }
}
