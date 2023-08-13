package de.trauma.backend.campaigns.monsters.action.exceptions;

public class ActionNotFoundException extends RuntimeException {
    public ActionNotFoundException(String message) {
        super(message);
    }
}
