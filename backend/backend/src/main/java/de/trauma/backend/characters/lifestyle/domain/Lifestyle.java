package de.trauma.backend.characters.lifestyle.domain;

import de.trauma.backend.characters.background.domain.Background;
import de.trauma.backend.characters.lifestyle.repository.LifestyleEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Lifestyle {
    private Long id;
    private String name;
    private String description;
    private int gold;
    private List<Background> backgrounds;

    public Lifestyle(LifestyleEntity lifestyle) {
        this.id = lifestyle.getId();
        this.name = lifestyle.getName();
        this.description = lifestyle.getDescription();
        this.gold = lifestyle.getGold();
        this.backgrounds = lifestyle.getBackgrounds().stream().map(Background::new).toList();
    }
}
