package de.trauma.backend.characters.feature.repository;

import de.trauma.backend.characters.background.repository.BackgroundEntity;
import de.trauma.backend.characters.characterclass.repository.CharacterClassEntity;
import de.trauma.backend.characters.feature.domain.Feature;
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
public class FeatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int level;

    @Column
    private String description;

    @ManyToMany(mappedBy = "features")
    private List<CharacterClassEntity> classes;

    @ManyToMany(mappedBy = "features")
    private List<BackgroundEntity> backgrounds;

    public FeatureEntity(Feature feature) {
        this.id = feature.getId();
        this.name = feature.getName();
        this.level = feature.getLevel();
        this.description = feature.getDescription();
        this.classes = feature.getClasses().stream().map(CharacterClassEntity::new).toList();
        this.backgrounds = feature.getBackgrounds().stream().map(BackgroundEntity::new).toList();
    }
}
