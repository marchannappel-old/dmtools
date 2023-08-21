package de.trauma.backend.characters.feature.controller;

import de.trauma.backend.campaigns.monsters.monster.controller.MonsterDTO;
import de.trauma.backend.characters.background.controller.BackgroundDTO;
import de.trauma.backend.characters.characterclass.controller.CharacterClassDTO;
import de.trauma.backend.characters.feature.domain.Feature;
import lombok.Getter;

import java.util.List;

@Getter
public class FeatureDTO {
    private final Long id;
    private final String name;
    private final int level;
    private final String description;
    private final List<CharacterClassDTO> classes;
    private final List<MonsterDTO> monsters;
    private final List<BackgroundDTO> backgrounds;

    public FeatureDTO(Feature feature) {
        this.id = feature.getId();
        this.name = feature.getName();
        this.level = feature.getLevel();
        this.description = feature.getDescription();
        this.classes = feature.getClasses().stream().map(CharacterClassDTO::new).toList();
        this.monsters = feature.getMonsters().stream().map(MonsterDTO::new).toList();
        this.backgrounds = feature.getBackgrounds().stream().map(BackgroundDTO::new).toList();
    }
}
