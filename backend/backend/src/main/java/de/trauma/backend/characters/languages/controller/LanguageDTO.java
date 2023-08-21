package de.trauma.backend.characters.languages.controller;

import de.trauma.backend.campaigns.monsters.monster.controller.MonsterDTO;
import de.trauma.backend.characters.background.controller.BackgroundDTO;
import de.trauma.backend.characters.languages.domain.Language;
import lombok.Getter;

import java.util.List;

@Getter
public class LanguageDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final String rarity;
    private final List<MonsterDTO> monsters;
    private final List<BackgroundDTO> backgrounds;

    public LanguageDTO(Language language) {
        this.id = language.getId();
        this.name = language.getName();
        this.description = language.getDescription();
        this.rarity = language.getRarity();
        this.monsters = language.getMonsters().stream().map(MonsterDTO::new).toList();
        this.backgrounds = language.getBackgrounds().stream().map(BackgroundDTO::new).toList();
    }
}
