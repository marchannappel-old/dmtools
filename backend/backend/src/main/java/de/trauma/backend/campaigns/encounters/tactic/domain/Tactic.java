package de.trauma.backend.campaigns.encounters.tactic.domain;

import de.trauma.backend.campaigns.encounters.encounter.domain.Encounter;
import de.trauma.backend.campaigns.encounters.tactic.repository.TacticEntity;

import java.util.List;

public class Tactic {
    private Long id;
    private String name;
    private String description;
    private List<Encounter> encounters;

    public Tactic(TacticEntity tactic) {
        this.id = tactic.getId();
        this.name = tactic.getName();
        this.description = tactic.getDescription();
        this.encounters = tactic.getEncounters().stream().map(Encounter::new).toList();
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
