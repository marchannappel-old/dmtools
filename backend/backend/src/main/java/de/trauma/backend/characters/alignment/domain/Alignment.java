package de.trauma.backend.characters.alignment.domain;

import de.trauma.backend.campaigns.monsters.monster.domain.Monster;
import de.trauma.backend.characters.alignment.repository.AlignmentEntity;
import de.trauma.backend.characters.background.domain.Background;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Alignment {
    private Long id;
    private String name;
    private String description;
    private List<Background> backgrounds;
    private List<Monster> monsters;

    public Alignment(AlignmentEntity alignment) {
        this.id = alignment.getId();
        this.name = alignment.getName();
        this.description = alignment.getDescription();
        this.backgrounds = alignment.getBackgrounds().stream().map(Background::new).toList();
        this.monsters = alignment.getMonsters().stream().map(Monster::new).toList();
    }
}
