package de.trauma.backend.campaigns.encounters.obstacle.controller;

import de.trauma.backend.campaigns.encounters.encounter.controller.EncounterDTO;
import de.trauma.backend.campaigns.encounters.obstacle.domain.Obstacle;
import lombok.Getter;

import java.util.List;

@Getter
public class ObstacleDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final String pronunciation;
    private final List<EncounterDTO> encounters;

    public ObstacleDTO(Obstacle obstacle) {
        this.id = obstacle.getId();
        this.name = obstacle.getName();
        this.description = obstacle.getDescription();
        this.pronunciation = obstacle.getPronunciation();
        this.encounters = obstacle.getEncounters().stream().map(EncounterDTO::new).toList();
    }
}
