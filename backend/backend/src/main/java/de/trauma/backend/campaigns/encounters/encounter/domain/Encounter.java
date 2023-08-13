package de.trauma.backend.campaigns.encounters.encounter.domain;

import de.trauma.backend.campaigns.encounters.consequence.domain.Consequence;
import de.trauma.backend.campaigns.encounters.encounter.repository.EncounterEntity;
import de.trauma.backend.campaigns.encounters.obstacle.domain.Obstacle;
import de.trauma.backend.campaigns.encounters.tactic.domain.Tactic;
import de.trauma.backend.characterCreation.item.domain.Item;
import de.trauma.backend.characterCreation.npc.domain.Npc;

import java.util.List;

public class Encounter {
    private Long id;
    private String setting;
    private String description;
    private String objective;
    private List<Npc> allies;
    private List<Obstacle> obstacles;
    private List<Tactic> tactics;
    private List<Item> rewards;
    private List<Consequence> consequences;

    public Encounter(EncounterEntity encounter) {
        this.id = encounter.getId();
        this.setting = encounter.getSetting();
        this.description = encounter.getDescription();
        this.objective = encounter.getObjective();
        this.allies = encounter.getAllies().stream().map(Npc::new).toList();
        this.obstacles = encounter.getObstacles().stream().map(Obstacle::new).toList();
        this.tactics = encounter.getTactics().stream().map(Tactic::new).toList();
        this.rewards = encounter.getRewards().stream().map(Item::new).toList();
        this.consequences = encounter.getConsequences().stream().map(Consequence::new).toList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public List<Npc> getAllies() {
        return allies;
    }

    public void setAllies(List<Npc> allies) {
        this.allies = allies;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public List<Tactic> getTactics() {
        return tactics;
    }

    public void setTactics(List<Tactic> tactics) {
        this.tactics = tactics;
    }

    public List<Item> getRewards() {
        return rewards;
    }

    public void setRewards(List<Item> rewards) {
        this.rewards = rewards;
    }

    public List<Consequence> getConsequences() {
        return consequences;
    }

    public void setConsequences(List<Consequence> consequences) {
        this.consequences = consequences;
    }
}
