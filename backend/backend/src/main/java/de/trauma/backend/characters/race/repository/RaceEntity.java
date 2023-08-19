package de.trauma.backend.characters.race.repository;

import de.trauma.backend.characters.character.repository.CharacterEntity;
import de.trauma.backend.characters.defense.repository.DefenseEntity;
import de.trauma.backend.characters.npc.repository.NpcEntity;
import de.trauma.backend.characters.race.domain.Race;
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
public class RaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String pronunciation;

    @Column
    private String subTitle;

    @Column
    private String description;

    @Column
    private String racialTraits;

    @Column
    private String appearance;

    @Column
    private String habitat;

    @Column
    private String peculiarities;

    @Column
    private String clans;

    @Column
    private String names;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private RaceEntity mainRace;

    @OneToMany(mappedBy = "mainRace", cascade = CascadeType.ALL)
    private List<RaceEntity> subraces;

    @ManyToMany
    @JoinTable(
            name = "race_defense",
            joinColumns = @JoinColumn(name = "race_id"),
            inverseJoinColumns = @JoinColumn(name = "defense_id")
    )
    private List<DefenseEntity> defenses;

    @ManyToMany(mappedBy = "races")
    private List<CharacterEntity> characters;

    @ManyToMany(mappedBy = "races")
    private List<NpcEntity> npcs;

    public RaceEntity(Race race) {
        this.id = race.getId();
        this.name = race.getName();
        this.pronunciation = race.getPronunciation();
        this.subTitle = race.getSubTitle();
        this.description = race.getDescription();
        this.racialTraits = race.getRacialTraits();
        this.appearance = race.getAppearance();
        this.habitat = race.getHabitat();
        this.peculiarities = race.getPeculiarities();
        this.clans = race.getClans();
        this.names = race.getNames();
        this.mainRace = new RaceEntity(race.getMainRace());
        this.subraces = race.getSubraces().stream().map(RaceEntity::new).toList();
        this.defenses = race.getDefenses().stream().map(DefenseEntity::new).toList();
        this.characters = race.getCharacters().stream().map(CharacterEntity::new).toList();
        this.npcs = race.getNpcs().stream().map(NpcEntity::new).toList();
    }
}
