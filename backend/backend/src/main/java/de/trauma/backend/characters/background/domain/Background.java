package de.trauma.backend.characters.background.domain;

import de.trauma.backend.campaigns.sessions.note.domain.Note;
import de.trauma.backend.characters.alignment.domain.Alignment;
import de.trauma.backend.characters.background.repository.BackgroundEntity;
import de.trauma.backend.characters.character.domain.Character;
import de.trauma.backend.characters.feature.domain.Feature;
import de.trauma.backend.characters.languages.domain.Language;
import de.trauma.backend.characters.lifestyle.domain.Lifestyle;
import de.trauma.backend.characters.npc.domain.Npc;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Background {
    private Long id;
    private String name;
    private String faith;
    private String hair;
    private String skin;
    private String eyes;
    private String height;
    private String weight;
    private String age;
    private String gender;
    private String personalityTraits;
    private String ideals;
    private String bonds;
    private String flaws;
    private String organisations;
    private String allies;
    private String enemies;
    private String backstory;
    private List<Language> languages;
    private List<Feature> features;
    private List<Alignment> alignments;
    private List<Lifestyle> lifestyles;
    private List<Note> notes;
    private Character character;
    private Npc npc;

    public Background(BackgroundEntity background) {
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
        this.languages = background.getLanguages().stream().map(Language::new).toList();
        this.features = background.getFeatures().stream().map(Feature::new).toList();
        this.alignments = background.getAlignments().stream().map(Alignment::new).toList();
        this.lifestyles = background.getLifestyles().stream().map(Lifestyle::new).toList();
        this.notes = background.getNotes().stream().map(Note::new).toList();
        this.character = new Character(background.getCharacter());
        this.npc = new Npc(background.getNpc());
    }
}
