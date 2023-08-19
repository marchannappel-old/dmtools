package de.trauma.backend.campaigns.encounters.obstacle.domain;

import de.trauma.backend.campaigns.encounters.encounter.domain.Encounter;
import de.trauma.backend.campaigns.encounters.obstacle.repository.ObstacleEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Obstacle {
    private Long id;
    private String name;
    private String description;
    private String pronunciation;
    private List<Encounter> encounters;

    public Obstacle(ObstacleEntity obstacle) {
        this.id = obstacle.getId();
        this.name = obstacle.getName();
        this.description = obstacle.getDescription();
        this.pronunciation = obstacle.getPronunciation();
        this.encounters = obstacle.getEncounters().stream().map(Encounter::new).toList();
    }
}
