package de.trauma.backend.characters.alignment.controller;

import de.trauma.backend.campaigns.monsters.monster.controller.MonsterDTO;
import de.trauma.backend.characters.alignment.domain.Alignment;
import de.trauma.backend.characters.background.controller.BackgroundDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class AlignmentDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<BackgroundDTO> backgrounds;
    private final List<MonsterDTO> monsters;

    public AlignmentDTO(Alignment alignment) {
        this.id = alignment.getId();
        this.name = alignment.getName();
        this.description = alignment.getDescription();
        this.backgrounds = alignment.getBackgrounds().stream().map(BackgroundDTO::new).toList();
        this.monsters = alignment.getMonsters().stream().map(MonsterDTO::new).toList();
    }
}
