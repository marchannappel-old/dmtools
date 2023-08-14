package de.trauma.backend.campaigns.encounters.consequence.controller;

import de.trauma.backend.campaigns.encounters.consequence.domain.Consequence;
import de.trauma.backend.campaigns.encounters.encounter.controller.EncounterDTO;

import java.util.List;

public class ConsequenceDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<EncounterDTO> encounters;

    public ConsequenceDTO(Consequence consequence) {
        this.id = consequence.getId();
        this.name = consequence.getName();
        this.description = consequence.getDescription();
        this.encounters = consequence.getEncounters().stream().map(EncounterDTO::new).toList();
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

    public List<EncounterDTO> getEncounters() {
        return encounters;
    }
}
