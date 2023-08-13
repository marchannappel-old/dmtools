package de.trauma.backend.campaigns.encounters.consequence.domain;

import de.trauma.backend.campaigns.encounters.consequence.repository.ConsequenceEntity;
import de.trauma.backend.campaigns.encounters.encounter.domain.Encounter;

import java.util.List;

public class Consequence {
    private Long id;
    private String name;
    private String description;
    private List<Encounter> encounters;

    public Consequence(ConsequenceEntity consequence) {
        this.id = consequence.getId();
        this.name = consequence.getName();
        this.description = consequence.getDescription();
        this.encounters = consequence.getEncounters().stream().map(Encounter::new).toList();
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

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<Encounter> encounters) {
        this.encounters = encounters;
    }
}
