package de.trauma.backend.characters.lifestyle.repository;

import de.trauma.backend.characters.background.repository.BackgroundEntity;
import de.trauma.backend.characters.lifestyle.domain.Lifestyle;
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
public class LifestyleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int gold;

    @ManyToMany(mappedBy = "lifestyles")
    private List<BackgroundEntity> backgrounds;

    public LifestyleEntity(Lifestyle lifestyle) {
        this.id = lifestyle.getId();
        this.name = lifestyle.getName();
        this.description = lifestyle.getDescription();
        this.gold = lifestyle.getGold();
        this.backgrounds = lifestyle.getBackgrounds().stream().map(BackgroundEntity::new).toList();
    }
}
