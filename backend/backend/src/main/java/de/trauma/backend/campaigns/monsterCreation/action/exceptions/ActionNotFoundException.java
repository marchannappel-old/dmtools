package de.trauma.backend.campaigns.monsterCreation.action.exceptions;

public class ActionNotFoundException extends RuntimeException {
    public ActionNotFoundException(String message) {
        super(message);
    }
}
