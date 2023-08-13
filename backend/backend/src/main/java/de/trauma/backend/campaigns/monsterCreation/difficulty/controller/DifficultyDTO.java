package de.trauma.backend.campaigns.monsterCreation.difficulty.controller;

import de.trauma.backend.campaigns.monsterCreation.difficulty.domain.Difficulty;
import de.trauma.backend.campaigns.monsterCreation.monster.controller.MonsterDTO;

import java.util.List;

public class DifficultyDTO {
    private final Long id;
    private final String name;
    private final int level;
    private final int experience;
    private final List<MonsterDTO> monsters;

    public DifficultyDTO(Difficulty difficulty) {
        this.id = difficulty.getId();
        this.name = difficulty.getName();
        this.level = difficulty.getLevel();
        this.experience = difficulty.getExperience();
        this.monsters = difficulty.getMonsters()
                .stream()
                .map(MonsterDTO::new)
                .toList();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public List<MonsterDTO> getMonsters() {
        return monsters;
    }
}
