package de.trauma.backend.campaigns.encounters.encounter.repository;

import de.trauma.backend.campaigns.encounters.consequence.repository.ConsequenceEntity;
import de.trauma.backend.campaigns.encounters.encounter.domain.Encounter;
import de.trauma.backend.campaigns.encounters.obstacle.repository.ObstacleEntity;
import de.trauma.backend.campaigns.encounters.tactic.repository.TacticEntity;
import de.trauma.backend.campaigns.monsters.monster.repository.MonsterEntity;
import de.trauma.backend.campaigns.plots.plot.repository.PlotEntity;
import de.trauma.backend.characters.items.item.repository.ItemEntity;
import de.trauma.backend.characters.npc.repository.NpcEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
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

    @ManyToMany
    @JoinTable(
            name = "encounter_monsters",
            joinColumns = @JoinColumn(name = "encounter_id"),
            inverseJoinColumns = @JoinColumn(name = "monster_id")
    )
    private List<MonsterEntity> monsters;

    @ManyToMany(mappedBy = "encounters")
    private List<PlotEntity> plots;

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
        this.monsters = encounter.getMonsters().stream().map(MonsterEntity::new).toList();
        this.plots = encounter.getPlots().stream().map(PlotEntity::new).toList();
    }
}
