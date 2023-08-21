package de.trauma.backend.characters.languages.repository;

import de.trauma.backend.campaigns.monsters.monster.repository.MonsterEntity;
import de.trauma.backend.characters.background.repository.BackgroundEntity;
import de.trauma.backend.characters.languages.domain.Language;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class LanguageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String rarity;

    @ManyToMany(mappedBy = "languages")
    private List<MonsterEntity> monsters;

    @ManyToMany(mappedBy = "languages")
    private List<BackgroundEntity> backgrounds;

    public LanguageEntity(Language language) {
        this.id = language.getId();
        this.name = language.getName();
        this.description = language.getDescription();
        this.rarity = language.getRarity();
        this.monsters = language.getMonsters().stream().map(MonsterEntity::new).toList();
        this.backgrounds = language.getBackgrounds().stream().map(BackgroundEntity::new).toList();
    }
}
