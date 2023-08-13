package de.trauma.backend.campaigns.encounters.encounter.controller;

import de.trauma.backend.campaigns.encounters.consequence.controller.ConsequenceDTO;
import de.trauma.backend.campaigns.encounters.encounter.domain.Encounter;
import de.trauma.backend.campaigns.encounters.obstacle.controller.ObstacleDTO;
import de.trauma.backend.campaigns.encounters.tactic.controller.TacticDTO;
import de.trauma.backend.characters.item.controller.ItemDTO;
import de.trauma.backend.characters.npc.controller.NpcDTO;

import java.util.List;

public class EncounterDTO {
    private final Long id;
    private final String setting;
    private final String description;
    private final String objective;
    private final List<NpcDTO> allies;
    private final List<ObstacleDTO> obstacles;
    private final List<TacticDTO> tactics;
    private final List<ItemDTO> rewards;
    private final List<ConsequenceDTO> consequences;

    public EncounterDTO(Encounter encounter) {
        this.id = encounter.getId();
        this.setting = encounter.getSetting();
        this.description = encounter.getDescription();
        this.objective = encounter.getObjective();
        this.allies = encounter.getAllies().stream().map(NpcDTO::new).toList();
        this.obstacles = encounter.getObstacles().stream().map(ObstacleDTO::new).toList();
        this.tactics = encounter.getTactics().stream().map(TacticDTO::new).toList();
        this.rewards = encounter.getRewards().stream().map(ItemDTO::new).toList();
        this.consequences = encounter.getConsequences().stream().map(ConsequenceDTO::new).toList();
    }

    public Long getId() {
        return id;
    }

    public String getSetting() {
        return setting;
    }

    public String getDescription() {
        return description;
    }

    public String getObjective() {
        return objective;
    }

    public List<NpcDTO> getAllies() {
        return allies;
    }

    public List<ObstacleDTO> getObstacles() {
        return obstacles;
    }

    public List<TacticDTO> getTactics() {
        return tactics;
    }

    public List<ItemDTO> getRewards() {
        return rewards;
    }

    public List<ConsequenceDTO> getConsequences() {
        return consequences;
    }
}
