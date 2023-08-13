package de.trauma.backend.campaigns.monsterCreation.monster.exceptions;

public class MonsterNotFoundException extends RuntimeException {
    public MonsterNotFoundException(String message) {
        super(message);
    }
}
