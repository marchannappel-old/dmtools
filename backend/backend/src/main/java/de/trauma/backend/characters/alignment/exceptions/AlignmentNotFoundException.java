package de.trauma.backend.characters.alignment.exceptions;

public class AlignmentNotFoundException extends RuntimeException {
    public AlignmentNotFoundException(String message) {
        super(message);
    }
}
