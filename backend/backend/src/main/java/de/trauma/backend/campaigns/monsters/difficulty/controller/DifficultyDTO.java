package de.trauma.backend.campaigns.monsters.difficulty.controller;

import de.trauma.backend.campaigns.monsters.difficulty.domain.Difficulty;
import de.trauma.backend.campaigns.monsters.monster.controller.MonsterDTO;
import lombok.Getter;

import java.util.List;

@Getter
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
}
