package de.trauma.backend.campaigns.monsters.action.controller;

import de.trauma.backend.campaigns.monsters.action.domain.Action;
import de.trauma.backend.campaigns.monsters.monster.controller.MonsterDTO;
import lombok.Getter;

import java.util.List;

@Getter
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
}
