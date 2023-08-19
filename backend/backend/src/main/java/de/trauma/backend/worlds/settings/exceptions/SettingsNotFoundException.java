package de.trauma.backend.worlds.settings.exceptions;

public class SettingsNotFoundException extends RuntimeException {
    public SettingsNotFoundException(String message) {
        super(message);
    }
}
