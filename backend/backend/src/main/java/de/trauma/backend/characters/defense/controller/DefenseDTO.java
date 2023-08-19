package de.trauma.backend.characters.defense.controller;

import de.trauma.backend.characters.defense.domain.Defense;
import de.trauma.backend.characters.race.controller.RaceDTO;

import java.util.List;

public class DefenseDTO {
    private Long id;
    private String name;
    private String description;
    private List<RaceDTO> races;

    public DefenseDTO(Defense defense) {
        this.id = defense.getId();
        this.name = defense.getName();
        this.description = defense.getDescription();
        this.races = defense.getRaces().stream().map(RaceDTO::new).toList();
    }
}
