package de.trauma.backend.characters.lifestyle.controller;

import de.trauma.backend.characters.background.controller.BackgroundDTO;
import de.trauma.backend.characters.lifestyle.domain.Lifestyle;
import lombok.Getter;

import java.util.List;

@Getter
public class LifestyleDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final int gold;
    private final List<BackgroundDTO> backgrounds;

    public LifestyleDTO(Lifestyle lifestyle) {
        this.id = lifestyle.getId();
        this.name = lifestyle.getName();
        this.description = lifestyle.getDescription();
        this.gold = lifestyle.getGold();
        this.backgrounds = lifestyle.getBackgrounds().stream().map(BackgroundDTO::new).toList();
    }
}
