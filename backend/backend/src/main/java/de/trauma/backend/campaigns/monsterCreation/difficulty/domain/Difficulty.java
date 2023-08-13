package de.trauma.backend.campaigns.monsterCreation.difficulty.domain;

import de.trauma.backend.campaigns.monsterCreation.monster.domain.Monster;
import de.trauma.backend.campaigns.monsterCreation.difficulty.repository.DifficultyEntity;

import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }
}
