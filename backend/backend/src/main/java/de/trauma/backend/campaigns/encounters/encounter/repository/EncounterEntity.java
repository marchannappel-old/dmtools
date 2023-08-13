package de.trauma.backend.campaigns.encounters.encounter.repository;

import de.trauma.backend.campaigns.encounters.consequence.repository.ConsequenceEntity;
import de.trauma.backend.campaigns.encounters.encounter.domain.Encounter;
import de.trauma.backend.campaigns.encounters.obstacle.repository.ObstacleEntity;
import de.trauma.backend.campaigns.encounters.tactic.repository.TacticEntity;
import de.trauma.backend.characters.item.repository.ItemEntity;
import de.trauma.backend.characters.npc.repository.NpcEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class EncounterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String setting;

    @Column
    private String description;

    @Column
    private String objective;

    @ManyToMany
    @JoinTable(
                name = "encounter_allies",
                joinColumns = @JoinColumn(name = "encounter_id"),
                inverseJoinColumns = @JoinColumn(name = "npc_id")
    )
    private List<NpcEntity> allies;

    @ManyToMany
    @JoinTable(
                name = "encounter_obstacles",
                joinColumns = @JoinColumn(name = "encounter_id"),
                inverseJoinColumns = @JoinColumn(name = "obstacle_id")
    )
    private List<ObstacleEntity> obstacles;

    @ManyToMany
    @JoinTable(
                name = "encounter_tactics",
                joinColumns = @JoinColumn(name = "encounter_id"),
                inverseJoinColumns = @JoinColumn(name = "tactic_id")
    )
    private List<TacticEntity> tactics;

    @ManyToMany
    @JoinTable(
                name = "encounter_rewards",
                joinColumns = @JoinColumn(name = "encounter_id"),
                inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemEntity> rewards;

    @ManyToMany
    @JoinTable(
                name = "encounter_consequences",
                joinColumns = @JoinColumn(name = "encounter_id"),
                inverseJoinColumns = @JoinColumn(name = "consequence_id")
    )
    private List<ConsequenceEntity> consequences;

    public EncounterEntity() {
    }

    public EncounterEntity(Encounter encounter) {
        this.id = encounter.getId();
        this.setting = encounter.getSetting();
        this.description = encounter.getDescription();
        this.objective = encounter.getObjective();
        this.allies = encounter.getAllies().stream().map(NpcEntity::new).toList();
        this.obstacles = encounter.getObstacles().stream().map(ObstacleEntity::new).toList();
        this.tactics = encounter.getTactics().stream().map(TacticEntity::new).toList();
        this.rewards = encounter.getRewards().stream().map(ItemEntity::new).toList();
        this.consequences = encounter.getConsequences().stream().map(ConsequenceEntity::new).toList();
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

    public List<NpcEntity> getAllies() {
        return allies;
    }

    public void setAllies(List<NpcEntity> allies) {
        this.allies = allies;
    }

    public List<ObstacleEntity> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<ObstacleEntity> obstacles) {
        this.obstacles = obstacles;
    }

    public List<TacticEntity> getTactics() {
        return tactics;
    }

    public void setTactics(List<TacticEntity> tactics) {
        this.tactics = tactics;
    }

    public List<ItemEntity> getRewards() {
        return rewards;
    }

    public void setRewards(List<ItemEntity> rewards) {
        this.rewards = rewards;
    }

    public List<ConsequenceEntity> getConsequences() {
        return consequences;
    }

    public void setConsequences(List<ConsequenceEntity> consequences) {
        this.consequences = consequences;
    }
}
