package de.trauma.backend.characters.background.controller;

import de.trauma.backend.campaigns.sessions.note.controller.NoteDTO;
import de.trauma.backend.characters.alignment.controller.AlignmentDTO;
import de.trauma.backend.characters.background.domain.Background;
import de.trauma.backend.characters.character.controller.CharacterDTO;
import de.trauma.backend.characters.feature.controller.FeatureDTO;
import de.trauma.backend.characters.languages.controller.LanguageDTO;
import de.trauma.backend.characters.lifestyle.controller.LifestyleDTO;
import de.trauma.backend.characters.npc.controller.NpcDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class BackgroundDTO {
    private final Long id;
    private final String name;
    private final String faith;
    private final String hair;
    private final String skin;
    private final String eyes;
    private final String height;
    private final String weight;
    private final String age;
    private final String gender;
    private final String personalityTraits;
    private final String ideals;
    private final String bonds;
    private final String flaws;
    private final String organisations;
    private final String allies;
    private final String enemies;
    private final String backstory;
    private final List<LanguageDTO> languages;
    private final List<FeatureDTO> features;
    private final List<AlignmentDTO> alignments;
    private final List<LifestyleDTO> lifestyles;
    private final List<NoteDTO> notes;
    private final CharacterDTO character;
    private final NpcDTO npc;

    public BackgroundDTO(Background background) {
        this.id = background.getId();
        this.name = background.getName();
        this.faith = background.getFaith();
        this.hair = background.getHair();
        this.skin = background.getSkin();
        this.eyes = background.getEyes();
        this.height = background.getHeight();
        this.weight = background.getWeight();
        this.age = background.getAge();
        this.gender = background.getGender();
        this.personalityTraits = background.getPersonalityTraits();
        this.ideals = background.getIdeals();
        this.bonds = background.getBonds();
        this.flaws = background.getFlaws();
        this.organisations = background.getOrganisations();
        this.allies = background.getAllies();
        this.enemies = background.getEnemies();
        this.backstory = background.getBackstory();
        this.languages = background.getLanguages().stream().map(LanguageDTO::new).toList();
        this.features = background.getFeatures().stream().map(FeatureDTO::new).toList();
        this.alignments = background.getAlignments().stream().map(AlignmentDTO::new).toList();
        this.lifestyles = background.getLifestyles().stream().map(LifestyleDTO::new).toList();
        this.notes = background.getNotes().stream().map(NoteDTO::new).toList();
        this.character = new CharacterDTO(background.getCharacter());
        this.npc = new NpcDTO(background.getNpc());
    }
}
