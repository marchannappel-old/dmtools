package de.trauma.backend.characters.race.controller;

import de.trauma.backend.characters.character.controller.CharacterDTO;
import de.trauma.backend.characters.defense.controller.DefenseDTO;
import de.trauma.backend.characters.npc.controller.NpcDTO;
import de.trauma.backend.characters.race.domain.Race;
import lombok.Getter;

import java.util.List;

@Getter
public class RaceDTO {
    private final Long id;
    private final String name;
    private final String pronunciation;
    private final String subTitle;
    private final String description;
    private final String racialTraits;
    private final String appearance;
    private final String habitat;
    private final String peculiarities;
    private final String clans;
    private final String names;
    private final RaceDTO mainRace;
    private final List<RaceDTO> subraces;
    private final List<DefenseDTO> defenses;
    private final List<CharacterDTO> characters;
    private final List<NpcDTO> npcs;

    public RaceDTO(Race race) {
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
        this.mainRace = new RaceDTO(race.getMainRace());
        this.subraces = race.getSubraces().stream().map(RaceDTO::new).toList();
        this.defenses = race.getDefenses().stream().map(DefenseDTO::new).toList();
        this.characters = race.getCharacters().stream().map(CharacterDTO::new).toList();
        this.npcs = race.getNpcs().stream().map(NpcDTO::new).toList();
    }
}
