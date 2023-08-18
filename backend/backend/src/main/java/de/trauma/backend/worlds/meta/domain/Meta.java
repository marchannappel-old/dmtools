package de.trauma.backend.worlds.meta.domain;

import de.trauma.backend.worlds.meta.repository.MetaEntity;
import de.trauma.backend.worlds.world.domain.World;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Meta {
    private Long id;
    private String motivation;
    private String goal;
    private String hook;
    private String genre;
    private String feel;
    private String characterAgency;
    private String tone;
    private String reccuringTheme;
    private String firstFocusPoint;
    private String secondFocusPoint;
    private String thirdFocusPoint;
    private String expandedFocusPoint;
    private String initialSize;
    private String naturalLaws;
    private String cosmology;
    private String geography;
    private String ancientPeople;
    private String species;
    private String needs;
    private String dramaPoint1;
    private String dramaPoint2;
    private String dramaPoint3;
    private String dramaPoint4;
    private String dramaPoint5;
    private String expandedDramaPoint;
    private String imagery;
    private String music;
    private String books;
    private String gaming;
    private World world;

    public Meta(MetaEntity meta) {
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
        this.world = new World(meta.getWorld());
    }
}
