package de.trauma.backend.campaigns.monsters.monster.repository;

import de.trauma.backend.campaigns.encounters.encounter.repository.EncounterEntity;
import de.trauma.backend.campaigns.monsters.action.repository.ActionEntity;
import de.trauma.backend.campaigns.monsters.difficulty.repository.DifficultyEntity;
import de.trauma.backend.campaigns.monsters.monster.domain.Monster;
import de.trauma.backend.campaigns.monsters.sense.repository.SenseEntity;
import de.trauma.backend.characters.ability.repository.AbilityEntity;
import de.trauma.backend.characters.alignment.repository.AlignmentEntity;
import de.trauma.backend.characters.feature.repository.FeatureEntity;
import de.trauma.backend.characters.item.repository.ItemEntity;
import de.trauma.backend.characters.languages.repository.LanguageEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
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

    public MonsterEntity() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getMovementRatePrimary() {
        return movementRatePrimary;
    }

    public void setMovementRatePrimary(int movementRatePrimary) {
        this.movementRatePrimary = movementRatePrimary;
    }

    public int getMovementRateSecondary() {
        return movementRateSecondary;
    }

    public void setMovementRateSecondary(int movementRateSecondary) {
        this.movementRateSecondary = movementRateSecondary;
    }

    public String getLair() {
        return lair;
    }

    public void setLair(String lair) {
        this.lair = lair;
    }

    public String getResistance() {
        return resistance;
    }

    public void setResistance(String resistance) {
        this.resistance = resistance;
    }

    public String getDamageImmunity() {
        return damageImmunity;
    }

    public void setDamageImmunity(String damageImmunity) {
        this.damageImmunity = damageImmunity;
    }

    public String getConditionImmunity() {
        return conditionImmunity;
    }

    public void setConditionImmunity(String conditionImmunity) {
        this.conditionImmunity = conditionImmunity;
    }

    public String getVulnerability() {
        return vulnerability;
    }

    public void setVulnerability(String vulnerability) {
        this.vulnerability = vulnerability;
    }

    public List<AlignmentEntity> getAlignments() {
        return alignments;
    }

    public void setAlignments(List<AlignmentEntity> alignments) {
        this.alignments = alignments;
    }

    public List<AbilityEntity> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilityEntity> abilities) {
        this.abilities = abilities;
    }

    public List<SenseEntity> getSenses() {
        return senses;
    }

    public void setSenses(List<SenseEntity> senses) {
        this.senses = senses;
    }

    public List<LanguageEntity> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageEntity> languages) {
        this.languages = languages;
    }

    public List<FeatureEntity> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureEntity> features) {
        this.features = features;
    }

    public List<ItemEntity> getLoot() {
        return loot;
    }

    public void setLoot(List<ItemEntity> loot) {
        this.loot = loot;
    }

    public List<DifficultyEntity> getDifficulties() {
        return difficulties;
    }

    public void setDifficulties(List<DifficultyEntity> difficulties) {
        this.difficulties = difficulties;
    }

    public List<ActionEntity> getActions() {
        return actions;
    }

    public void setActions(List<ActionEntity> actions) {
        this.actions = actions;
    }

    public List<EncounterEntity> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<EncounterEntity> encounters) {
        this.encounters = encounters;
    }
}
