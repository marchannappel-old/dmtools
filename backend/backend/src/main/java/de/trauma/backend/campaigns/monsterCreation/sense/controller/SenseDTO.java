package de.trauma.backend.campaigns.monsterCreation.sense.controller;

import de.trauma.backend.campaigns.monsterCreation.monster.controller.MonsterDTO;
import de.trauma.backend.campaigns.monsterCreation.sense.domain.Sense;

import java.util.List;

public class SenseDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<MonsterDTO> monsters;

    public SenseDTO(Sense sense) {
        this.id = sense.getId();
        this.name = sense.getName();
        this.description = sense.getDescription();
        this.monsters = sense.getMonsters()
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

    public String getDescription() {
        return description;
    }

    public List<MonsterDTO> getMonsters() {
        return monsters;
    }
}
