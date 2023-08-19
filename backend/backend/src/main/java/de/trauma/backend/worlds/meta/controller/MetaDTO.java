package de.trauma.backend.worlds.meta.controller;

import de.trauma.backend.worlds.meta.domain.Meta;
import de.trauma.backend.worlds.world.controller.WorldDTO;
import lombok.Getter;

@Getter
public class MetaDTO {
    private final Long id;
    private final String motivation;
    private final String goal;
    private final String hook;
    private final String genre;
    private final String feel;
    private final String characterAgency;
    private final String tone;
    private final String reccuringTheme;
    private final String firstFocusPoint;
    private final String secondFocusPoint;
    private final String thirdFocusPoint;
    private final String expandedFocusPoint;
    private final String initialSize;
    private final String naturalLaws;
    private final String cosmology;
    private final String geography;
    private final String ancientPeople;
    private final String species;
    private final String needs;
    private final String dramaPoint1;
    private final String dramaPoint2;
    private final String dramaPoint3;
    private final String dramaPoint4;
    private final String dramaPoint5;
    private final String expandedDramaPoint;
    private final String imagery;
    private final String music;
    private final String books;
    private final String gaming;
    private final WorldDTO world;

    public MetaDTO(Meta meta) {
        this.id = meta.getId();
        this.motivation = meta.getMotivation();
        this.goal = meta.getGoal();
        this.hook = meta.getHook();
        this.genre = meta.getGenre();
        this.feel = meta.getFeel();
        this.characterAgency = meta.getCharacterAgency();
        this.tone = meta.getTone();
        this.reccuringTheme = meta.getReccuringTheme();
        this.firstFocusPoint = meta.getFirstFocusPoint();
        this.secondFocusPoint = meta.getSecondFocusPoint();
        this.thirdFocusPoint = meta.getThirdFocusPoint();
        this.expandedFocusPoint = meta.getExpandedFocusPoint();
        this.initialSize = meta.getInitialSize();
        this.naturalLaws = meta.getNaturalLaws();
        this.cosmology = meta.getCosmology();
        this.geography = meta.getGeography();
        this.ancientPeople = meta.getAncientPeople();
        this.species = meta.getSpecies();
        this.needs = meta.getNeeds();
        this.dramaPoint1 = meta.getDramaPoint1();
        this.dramaPoint2 = meta.getDramaPoint2();
        this.dramaPoint3 = meta.getDramaPoint3();
        this.dramaPoint4 = meta.getDramaPoint4();
        this.dramaPoint5 = meta.getDramaPoint5();
        this.expandedDramaPoint = meta.getExpandedDramaPoint();
        this.imagery = meta.getImagery();
        this.music = meta.getMusic();
        this.books = meta.getBooks();
        this.gaming = meta.getGaming();
        this.world = new WorldDTO(meta.getWorld());
    }
}
