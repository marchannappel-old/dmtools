package de.trauma.backend.campaigns.monsterCreation.monster.controller;

import de.trauma.backend.campaigns.encounters.encounter.controller.EncounterDTO;
import de.trauma.backend.campaigns.monsterCreation.action.controller.ActionDTO;
import de.trauma.backend.campaigns.monsterCreation.difficulty.controller.DifficultyDTO;
import de.trauma.backend.campaigns.monsterCreation.monster.domain.Monster;
import de.trauma.backend.campaigns.monsterCreation.sense.controller.SenseDTO;
import de.trauma.backend.characterCreation.ability.controller.AbilityDTO;
import de.trauma.backend.characterCreation.alignment.controller.AlignmentDTO;
import de.trauma.backend.characterCreation.feature.controller.FeatureDTO;
import de.trauma.backend.characterCreation.item.controller.ItemDTO;
import de.trauma.backend.characterCreation.languages.controller.LanguageDTO;

import java.util.List;

public class MonsterDTO {
    private final Long id;
    private final String name;
    private final String type;
    private final String subtype;
    private final int size;
    private final String environment;
    private final String description;
    private final int armorClass;
    private final int hitPoints;
    private final int currentHitPoints;
    private final int movementRatePrimary;
    private final int movementRateSecondary;
    private final String lair;
    private final String resistance;
    private final String damageImmunity;
    private final String conditionImmunity;
    private final String vulnerability;
    private final List<AlignmentDTO> alignments;
    private final List<AbilityDTO> abilities;
    private final List<SenseDTO> senses;
    private final List<LanguageDTO> languages;
    private final List<FeatureDTO> features;
    private final List<ItemDTO> loot;
    private final List<DifficultyDTO> difficulties;
    private final List<ActionDTO> actions;
    private final List<EncounterDTO> encounters;

    public MonsterDTO(Monster monster) {
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
        this.alignments = monster.getAlignments().stream().map(AlignmentDTO::new).toList();
        this.abilities = monster.getAbilities().stream().map(AbilityDTO::new).toList();
        this.senses = monster.getSenses().stream().map(SenseDTO::new).toList();
        this.languages = monster.getLanguages().stream().map(LanguageDTO::new).toList();
        this.features = monster.getFeatures().stream().map(FeatureDTO::new).toList();
        this.loot = monster.getLoot().stream().map(ItemDTO::new).toList();
        this.difficulties = monster.getDifficulties().stream().map(DifficultyDTO::new).toList();
        this.actions = monster.getActions().stream().map(ActionDTO::new).toList();
        this.encounters = monster.getEncounters().stream().map(EncounterDTO::new).toList();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }

    public int getSize() {
        return size;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getDescription() {
        return description;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public int getMovementRatePrimary() {
        return movementRatePrimary;
    }

    public int getMovementRateSecondary() {
        return movementRateSecondary;
    }

    public String getLair() {
        return lair;
    }

    public String getResistance() {
        return resistance;
    }

    public String getDamageImmunity() {
        return damageImmunity;
    }

    public String getConditionImmunity() {
        return conditionImmunity;
    }

    public String getVulnerability() {
        return vulnerability;
    }

    public List<AlignmentDTO> getAlignments() {
        return alignments;
    }

    public List<AbilityDTO> getAbilities() {
        return abilities;
    }

    public List<SenseDTO> getSenses() {
        return senses;
    }

    public List<LanguageDTO> getLanguages() {
        return languages;
    }

    public List<FeatureDTO> getFeatures() {
        return features;
    }

    public List<ItemDTO> getLoot() {
        return loot;
    }

    public List<DifficultyDTO> getDifficulties() {
        return difficulties;
    }

    public List<ActionDTO> getActions() {
        return actions;
    }

    public List<EncounterDTO> getEncounters() {
        return encounters;
    }
}
