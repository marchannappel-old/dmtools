package de.trauma.backend.characters.race.domain;

import de.trauma.backend.characters.defense.domain.Defense;
import de.trauma.backend.characters.npc.domain.Npc;
import de.trauma.backend.characters.race.repository.RaceEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Race {
    private Long id;
    private String name;
    private String pronunciation;
    private String subTitle;
    private String description;
    private String racialTraits;
    private String appearance;
    private String habitat;
    private String peculiarities;
    private String clans;
    private String names;
    private Race mainRace;
    private List<Race> subraces;
    private List<Defense> defenses;
    private List<Character> characters;
    private List<Npc> npcs;

    public Race(RaceEntity race) {
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
        this.mainRace = new Race(race.getMainRace());
        this.subraces = race.getSubraces().stream().map(Race::new).toList();
        this.defenses = race.getDefenses().stream().map(Defense::new).toList();
        this.characters = race.getCharacters().stream().map(Character::new).toList();
        this.npcs = race.getNpcs().stream().map(Npc::new).toList();
    }
}
