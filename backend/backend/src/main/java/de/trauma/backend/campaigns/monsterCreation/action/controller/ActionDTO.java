package de.trauma.backend.campaigns.monsterCreation.action.controller;

import de.trauma.backend.campaigns.monsterCreation.action.domain.Action;
import de.trauma.backend.campaigns.monsterCreation.monster.controller.MonsterDTO;

import java.util.List;

public class ActionDTO {
    private final Long id;
    private final String name;
    private final String type;
    private final String description;
    private final String rarity;
    private final List<MonsterDTO> monsters;

    public ActionDTO(Action action) {
        this.id = action.getId();
        this.name = action.getName();
        this.type = action.getType();
        this.description = action.getDescription();
        this.rarity = action.getRarity();
        this.monsters = action.getMonsters()
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

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getRarity() {
        return rarity;
    }

    public List<MonsterDTO> getMonsters() {
        return monsters;
    }
}
