package de.trauma.backend.characters.feature.domain;

import de.trauma.backend.campaigns.monsters.monster.domain.Monster;
import de.trauma.backend.characters.background.domain.Background;
import de.trauma.backend.characters.characterclass.domain.CharacterClass;
import de.trauma.backend.characters.feature.repository.FeatureEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Feature {
    private Long id;
    private String name;
    private int level;
    private String description;
    private List<CharacterClass> classes;
    private List<Monster> monsters;
    private List<Background> backgrounds;

    public Feature(FeatureEntity feature) {
        this.id = feature.getId();
        this.name = feature.getName();
        this.level = feature.getLevel();
        this.description = feature.getDescription();
        this.classes = feature.getClasses().stream().map(CharacterClass::new).toList();
        this.monsters = feature.getMonsters().stream().map(Monster::new).toList();
        this.backgrounds = feature.getBackgrounds().stream().map(Background::new).toList();
    }
}
