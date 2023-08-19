package de.trauma.backend.campaigns.encounters.tactic.controller;

import de.trauma.backend.campaigns.encounters.encounter.controller.EncounterDTO;
import de.trauma.backend.campaigns.encounters.tactic.domain.Tactic;
import lombok.Getter;

import java.util.List;

@Getter
public class TacticDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<EncounterDTO> encounters;

    public TacticDTO(Tactic tactic) {
        this.id = tactic.getId();
        this.name = tactic.getName();
        this.description = tactic.getDescription();
        this.encounters = tactic.getEncounters().stream().map(EncounterDTO::new).toList();
    }
}
