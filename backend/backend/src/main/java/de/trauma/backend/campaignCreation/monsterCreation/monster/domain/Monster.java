package de.trauma.backend.campaignCreation.monsterCreation.monster.domain;

import de.trauma.backend.campaignCreation.encounter.domain.Encounter;
import de.trauma.backend.campaignCreation.monsterCreation.action.domain.Action;
import de.trauma.backend.campaignCreation.monsterCreation.difficulty.domain.Difficulty;
import de.trauma.backend.campaignCreation.monsterCreation.sense.domain.Sense;
import de.trauma.backend.campaignCreation.monsterCreation.monster.repository.MonsterEntity;
import de.trauma.backend.characterCreation.ability.domain.Ability;
import de.trauma.backend.characterCreation.alignment.domain.Alignment;
import de.trauma.backend.characterCreation.feature.domain.Feature;
import de.trauma.backend.characterCreation.item.domain.Item;
import de.trauma.backend.characterCreation.languages.domain.Language;

import java.util.List;

public class Monster {
    private Long id;
    private String name;
    private String type;
    private String subtype;
    private int size;
    private String environment;
    private String description;
    private int armorClass;
    private int hitPoints;
    private int currentHitPoints;
    private int movementRatePrimary;
    private int movementRateSecondary;
    private String lair;
    private String resistance;
    private String damageImmunity;
    private String conditionImmunity;
    private String vulnerability;
    private List<Alignment> alignments;
    private List<Ability> abilities;
    private List<Sense> senses;
    private List<Language> languages;
    private List<Feature> features;
    private List<Item> loot;
    private List<Difficulty> difficulties;
    private List<Action> actions;
    private List<Encounter> encounters;

    public Monster(MonsterEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.type = entity.getType();
        this.subtype = entity.getSubtype();
        this.size = entity.getSize();
        this.environment = entity.getEnvironment();
        this.description = entity.getDescription();
        this.armorClass = entity.getArmorClass();
        this.hitPoints = entity.getHitPoints();
        this.currentHitPoints = entity.getCurrentHitPoints();
        this.movementRatePrimary = entity.getMovementRatePrimary();
        this.movementRateSecondary = entity.getMovementRateSecondary();
        this.lair = entity.getLair();
        this.resistance = entity.getResistance();
        this.damageImmunity = entity.getDamageImmunity();
        this.conditionImmunity = entity.getConditionImmunity();
        this.vulnerability = entity.getVulnerability();
        this.alignments = entity.getAlignments().stream().map(Alignment::new).toList();
        this.abilities = entity.getAbilities().stream().map(Ability::new).toList();
        this.senses = entity.getSenses().stream().map(Sense::new).toList();
        this.languages = entity.getLanguages().stream().map(Language::new).toList();
        this.features = entity.getFeatures().stream().map(Feature::new).toList();
        this.loot = entity.getLoot().stream().map(Item::new).toList();
        this.difficulties = entity.getDifficulties().stream().map(Difficulty::new).toList();
        this.actions = entity.getActions().stream().map(Action::new).toList();
        this.encounters = entity.getEncounters().stream().map(Encounter::new).toList();
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

    public List<Alignment> getAlignments() {
        return alignments;
    }

    public void setAlignments(List<Alignment> alignments) {
        this.alignments = alignments;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Sense> getSenses() {
        return senses;
    }

    public void setSenses(List<Sense> senses) {
        this.senses = senses;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<Item> getLoot() {
        return loot;
    }

    public void setLoot(List<Item> loot) {
        this.loot = loot;
    }

    public List<Difficulty> getDifficulties() {
        return difficulties;
    }

    public void setDifficulties(List<Difficulty> difficulties) {
        this.difficulties = difficulties;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<Encounter> encounters) {
        this.encounters = encounters;
    }
}
