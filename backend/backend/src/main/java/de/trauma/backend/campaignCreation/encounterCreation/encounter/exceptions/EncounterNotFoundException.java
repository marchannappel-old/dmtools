package de.trauma.backend.campaignCreation.encounterCreation.encounter.exceptions;

public class EncounterNotFoundException extends RuntimeException {
    public EncounterNotFoundException(String message) {
        super(message);
    }
}
