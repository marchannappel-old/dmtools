package de.trauma.backend.campaigns.monsters.monster.domain;

import de.trauma.backend.campaigns.encounters.encounter.domain.Encounter;
import de.trauma.backend.campaigns.monsters.action.domain.Action;
import de.trauma.backend.campaigns.monsters.difficulty.domain.Difficulty;
import de.trauma.backend.campaigns.monsters.sense.domain.Sense;
import de.trauma.backend.campaigns.monsters.monster.repository.MonsterEntity;
import de.trauma.backend.characters.ability.domain.Ability;
import de.trauma.backend.characters.alignment.domain.Alignment;
import de.trauma.backend.characters.feature.domain.Feature;
import de.trauma.backend.characters.items.item.domain.Item;
import de.trauma.backend.characters.languages.domain.Language;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
}
