package de.trauma.backend.campaignCreation.encounterCreation.obstacle.controller;

import de.trauma.backend.campaignCreation.encounterCreation.encounter.domain.Encounter;
import de.trauma.backend.campaignCreation.encounterCreation.obstacle.domain.Obstacle;

import java.util.List;

public class ObstacleDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final String pronunciation;
    private final List<Encounter> encounters;

    public ObstacleDTO(Obstacle obstacle) {
        this.id = obstacle.getId();
        this.name = obstacle.getName();
        this.description = obstacle.getDescription();
        this.pronunciation = obstacle.getPronunciation();
        this.encounters = obstacle.getEncounters();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public List<Encounter> getEncounters() {
        return encounters;
    }
}
