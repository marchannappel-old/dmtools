package de.trauma.backend.characters.defense.repository;

import de.trauma.backend.characters.defense.domain.Defense;
import de.trauma.backend.characters.race.repository.RaceEntity;
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
public class DefenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "defenses")
    private List<RaceEntity> races;

    public DefenseEntity(Defense defense) {
        this.id = defense.getId();
        this.name = defense.getName();
        this.description = defense.getDescription();
        this.races = defense.getRaces().stream().map(RaceEntity::new).toList();
    }
}
