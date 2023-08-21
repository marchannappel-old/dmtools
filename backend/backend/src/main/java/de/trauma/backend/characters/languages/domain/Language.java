package de.trauma.backend.characters.languages.domain;

import de.trauma.backend.campaigns.monsters.monster.domain.Monster;
import de.trauma.backend.characters.background.domain.Background;
import de.trauma.backend.characters.languages.repository.LanguageEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Language {
    private Long id;
    private String name;
    private String description;
    private String rarity;
    private List<Monster> monsters;
    private List<Background> backgrounds;

    public Language(LanguageEntity language) {
        this.id = language.getId();
        this.name = language.getName();
        this.description = language.getDescription();
        this.rarity = language.getRarity();
        this.monsters = language.getMonsters().stream().map(Monster::new).toList();
        this.backgrounds = language.getBackgrounds().stream().map(Background::new).toList();
    }
}
