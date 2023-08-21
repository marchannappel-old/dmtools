package de.trauma.backend.campaigns.monsters.monster.repository;

import de.trauma.backend.campaigns.encounters.encounter.repository.EncounterEntity;
import de.trauma.backend.campaigns.monsters.action.repository.ActionEntity;
import de.trauma.backend.campaigns.monsters.difficulty.repository.DifficultyEntity;
import de.trauma.backend.campaigns.monsters.monster.domain.Monster;
import de.trauma.backend.campaigns.monsters.sense.repository.SenseEntity;
import de.trauma.backend.characters.ability.repository.AbilityEntity;
import de.trauma.backend.characters.alignment.repository.AlignmentEntity;
import de.trauma.backend.characters.feature.repository.FeatureEntity;
import de.trauma.backend.characters.items.item.repository.ItemEntity;
import de.trauma.backend.characters.languages.repository.LanguageEntity;
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
public class MonsterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private String subtype;

    @Column
    private int size;

    @Column
    private String environment;

    @Column
    private String description;

    @Column
    private int armorClass;

    @Column
    private int hitPoints;

    @Column
    private int currentHitPoints;

    @Column
    private int movementRatePrimary;

    @Column
    private int movementRateSecondary;

    @Column
    private String lair;

    @Column
    private String resistance;

    @Column
    private String damageImmunity;

    @Column
    private String conditionImmunity;

    @Column
    private String vulnerability;

    @ManyToMany
    @JoinTable(
            name = "monster_alignment",
            joinColumns = @JoinColumn(name = "monster_id"),
            inverseJoinColumns = @JoinColumn(name = "alignment_id")
    )
    private List<AlignmentEntity> alignments;

    @ManyToMany
    @JoinTable(
            name = "monster_ability",
            joinColumns = @JoinColumn(name = "monster_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    private List<AbilityEntity> abilities;

    @ManyToMany
    @JoinTable(
            name = "monster_sense",
            joinColumns = @JoinColumn(name = "monster_id"),
            inverseJoinColumns = @JoinColumn(name = "sense_id")
    )
    private List<SenseEntity> senses;

    @ManyToMany
    @JoinTable(
            name = "monster_language",
            joinColumns = @JoinColumn(name = "monster_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<LanguageEntity> languages;

    @ManyToMany
    @JoinTable(
            name = "monster_feature",
            joinColumns = @JoinColumn(name = "monster_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private List<FeatureEntity> features;

    @ManyToMany
    @JoinTable(
            name = "monster_loot",
            joinColumns = @JoinColumn(name = "monster_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemEntity> loot;

    @ManyToMany
    @JoinTable(
            name = "monster_difficulty",
            joinColumns = @JoinColumn(name = "monster_id"),
            inverseJoinColumns = @JoinColumn(name = "difficulty_id")
    )
    private List<DifficultyEntity> difficulties;

    @ManyToMany
    @JoinTable(
            name = "monster_action",
            joinColumns = @JoinColumn(name = "monster_id"),
            inverseJoinColumns = @JoinColumn(name = "action_id")
    )
    private List<ActionEntity> actions;

    @ManyToMany(mappedBy = "monsters")
    private List<EncounterEntity> encounters;

    public MonsterEntity(Monster monster) {
        this.id = monster.getId();
        this.name = monster.getName();
        this.type = monster.getType();
        this.subtype = monster.getSubtype();
        this.size = monster.getSize();
        this.environment = monster.getEnvironment();
        this.description = monster.getDescription();
        this.armorClass = monster.getArmorClass();
        this.hitPoints = monster.getHitPoints();
        this.currentHitPoints = monster.getCurrentHitPoints();
        this.movementRatePrimary = monster.getMovementRatePrimary();
        this.movementRateSecondary = monster.getMovementRateSecondary();
        this.lair = monster.getLair();
        this.resistance = monster.getResistance();
        this.damageImmunity = monster.getDamageImmunity();
        this.conditionImmunity = monster.getConditionImmunity();
        this.vulnerability = monster.getVulnerability();
        this.alignments = monster.getAlignments().stream().map(AlignmentEntity::new).toList();
        this.abilities = monster.getAbilities().stream().map(AbilityEntity::new).toList();
        this.senses = monster.getSenses().stream().map(SenseEntity::new).toList();
        this.languages = monster.getLanguages().stream().map(LanguageEntity::new).toList();
        this.features = monster.getFeatures().stream().map(FeatureEntity::new).toList();
        this.loot = monster.getLoot().stream().map(ItemEntity::new).toList();
        this.difficulties = monster.getDifficulties().stream().map(DifficultyEntity::new).toList();
        this.actions = monster.getActions().stream().map(ActionEntity::new).toList();
        this.encounters = monster.getEncounters().stream().map(EncounterEntity::new).toList();
    }
}
