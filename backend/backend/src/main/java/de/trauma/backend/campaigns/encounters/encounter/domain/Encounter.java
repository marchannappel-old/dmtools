package de.trauma.backend.campaigns.encounters.encounter.domain;

import de.trauma.backend.campaigns.encounters.consequence.domain.Consequence;
import de.trauma.backend.campaigns.encounters.encounter.repository.EncounterEntity;
import de.trauma.backend.campaigns.encounters.obstacle.domain.Obstacle;
import de.trauma.backend.campaigns.encounters.tactic.domain.Tactic;
import de.trauma.backend.campaigns.monsters.monster.domain.Monster;
import de.trauma.backend.campaigns.plots.plot.domain.Plot;
import de.trauma.backend.characters.item.domain.Item;
import de.trauma.backend.characters.npc.domain.Npc;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
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
    private List<Monster> monsters;
    private List<Plot> plots;

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
        this.monsters = encounter.getMonsters().stream().map(Monster::new).toList();
        this.plots = encounter.getPlots().stream().map(Plot::new).toList();
    }
}
