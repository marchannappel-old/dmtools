package de.trauma.backend.campaigns.monsters.difficulty.domain;

import de.trauma.backend.campaigns.monsters.monster.domain.Monster;
import de.trauma.backend.campaigns.monsters.difficulty.repository.DifficultyEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Difficulty {
    private Long id;
    private String name;
    private int level;
    private int experience;
    private List<Monster> monsters;

    public Difficulty(DifficultyEntity difficulty) {
        this.id = difficulty.getId();
        this.name = difficulty.getName();
        this.level = difficulty.getLevel();
        this.experience = difficulty.getExperience();
        this.monsters = difficulty.getMonsters()
                .stream()
                .map(Monster::new)
                .toList();
    }
}
