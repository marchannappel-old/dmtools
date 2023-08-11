package de.trauma.backend.campaignCreation.monsterCreation.action.exceptions;

public class ActionNotFoundException extends RuntimeException {
    public ActionNotFoundException(String message) {
        super(message);
    }
}
