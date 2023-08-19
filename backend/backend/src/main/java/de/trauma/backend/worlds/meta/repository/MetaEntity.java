package de.trauma.backend.worlds.meta.repository;

import de.trauma.backend.worlds.meta.domain.Meta;
import de.trauma.backend.worlds.world.repository.WorldEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class MetaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String motivation;

    @Column
    private String goal;

    @Column
    private String hook;

    @Column
    private String genre;

    @Column
    private String feel;

    @Column
    private String characterAgency;

    @Column
    private String tone;

    @Column
    private String reccuringTheme;

    @Column
    private String firstFocusPoint;

    @Column
    private String secondFocusPoint;

    @Column
    private String thirdFocusPoint;

    @Column
    private String expandedFocusPoint;

    @Column
    private String initialSize;

    @Column
    private String naturalLaws;

    @Column
    private String cosmology;

    @Column
    private String geography;

    @Column
    private String ancientPeople;

    @Column
    private String species;

    @Column
    private String needs;

    @Column
    private String dramaPoint1;

    @Column
    private String dramaPoint2;

    @Column
    private String dramaPoint3;

    @Column
    private String dramaPoint4;

    @Column
    private String dramaPoint5;

    @Column
    private String expandedDramaPoint;

    @Column
    private String imagery;

    @Column
    private String music;

    @Column
    private String books;

    @Column
    private String gaming;

    @OneToOne(mappedBy = "meta")
    private WorldEntity world;

    public MetaEntity(Meta meta) {
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
        this.world = new WorldEntity(meta.getWorld());
    }
}
