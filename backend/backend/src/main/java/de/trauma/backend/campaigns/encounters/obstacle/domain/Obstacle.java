package de.trauma.backend.campaigns.encounters.obstacle.domain;

import de.trauma.backend.campaigns.encounters.encounter.domain.Encounter;
import de.trauma.backend.campaigns.encounters.obstacle.repository.ObstacleEntity;

import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<Encounter> encounters) {
        this.encounters = encounters;
    }
}
