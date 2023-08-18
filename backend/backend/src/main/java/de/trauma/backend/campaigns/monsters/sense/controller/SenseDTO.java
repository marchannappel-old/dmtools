package de.trauma.backend.campaigns.monsters.sense.controller;

import de.trauma.backend.campaigns.monsters.monster.controller.MonsterDTO;
import de.trauma.backend.campaigns.monsters.sense.domain.Sense;
import lombok.Getter;

import java.util.List;

@Getter
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
}
