package de.trauma.backend.campaigns.encounters.consequence.domain;

import de.trauma.backend.campaigns.encounters.consequence.repository.ConsequenceEntity;
import de.trauma.backend.campaigns.encounters.encounter.domain.Encounter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
}
