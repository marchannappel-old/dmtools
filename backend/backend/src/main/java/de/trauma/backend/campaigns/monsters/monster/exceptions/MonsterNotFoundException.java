package de.trauma.backend.campaigns.monsters.monster.exceptions;

public class MonsterNotFoundException extends RuntimeException {
    public MonsterNotFoundException(String message) {
        super(message);
    }
}
