package de.trauma.backend.campaigns.encounters.tactic.domain;

import de.trauma.backend.campaigns.encounters.encounter.domain.Encounter;
import de.trauma.backend.campaigns.encounters.tactic.repository.TacticEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
}
