package de.trauma.backend.campaigns.monsterCreation.sense.domain;

import de.trauma.backend.campaigns.monsterCreation.monster.domain.Monster;
import de.trauma.backend.campaigns.monsterCreation.sense.repository.SenseEntity;

import java.util.List;

public class Sense {
    private Long id;
    private String name;
    private String description;
    private List<Monster> monsters;

    public Sense(SenseEntity sense) {
        this.id = sense.getId();
        this.name = sense.getName();
        this.description = sense.getDescription();
        this.monsters = sense.getMonsters()
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }
}
