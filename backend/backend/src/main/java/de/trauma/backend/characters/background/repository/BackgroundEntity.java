package de.trauma.backend.characters.background.repository;

import de.trauma.backend.campaigns.sessions.note.repository.NoteEntity;
import de.trauma.backend.characters.alignment.repository.AlignmentEntity;
import de.trauma.backend.characters.background.domain.Background;
import de.trauma.backend.characters.character.repository.CharacterEntity;
import de.trauma.backend.characters.feature.repository.FeatureEntity;
import de.trauma.backend.characters.languages.repository.LanguageEntity;
import de.trauma.backend.characters.lifestyle.repository.LifestyleEntity;
import de.trauma.backend.characters.npc.repository.NpcEntity;
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
public class BackgroundEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String faith;

    @Column
    private String hair;

    @Column
    private String skin;

    @Column
    private String eyes;

    @Column
    private String height;

    @Column
    private String weight;

    @Column
    private String age;

    @Column
    private String gender;

    @Column
    private String personalityTraits;

    @Column
    private String ideals;

    @Column
    private String bonds;

    @Column
    private String flaws;

    @Column
    private String organisations;

    @Column
    private String allies;

    @Column
    private String enemies;

    @Column
    private String backstory;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "background_language",
            joinColumns = @JoinColumn(name = "background_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<LanguageEntity> languages;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "background_feature",
            joinColumns = @JoinColumn(name = "background_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private List<FeatureEntity> features;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "backround_alignment",
            joinColumns = @JoinColumn(name = "background_id"),
            inverseJoinColumns = @JoinColumn(name = "alignment_id")
    )
    private List<AlignmentEntity> alignments;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "background_lifestyle",
            joinColumns = @JoinColumn(name = "background_id"),
            inverseJoinColumns = @JoinColumn(name = "lifestyle_id")
    )
    private List<LifestyleEntity> lifestyles;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "background_note",
            joinColumns = @JoinColumn(name = "background_id"),
            inverseJoinColumns = @JoinColumn(name = "note_id")
    )
    private List<NoteEntity> notes;

    @OneToOne(mappedBy = "background")
    private CharacterEntity character;

    @OneToOne(mappedBy = "background")
    private NpcEntity npc;

    public BackgroundEntity(Background background) {
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
        this.languages = background.getLanguages().stream().map(LanguageEntity::new).toList();
        this.features = background.getFeatures().stream().map(FeatureEntity::new).toList();
        this.alignments = background.getAlignments().stream().map(AlignmentEntity::new).toList();
        this.lifestyles = background.getLifestyles().stream().map(LifestyleEntity::new).toList();
        this.notes = background.getNotes().stream().map(NoteEntity::new).toList();
        this.character = new CharacterEntity(background.getCharacter());
        this.npc = new NpcEntity(background.getNpc());
    }
}

