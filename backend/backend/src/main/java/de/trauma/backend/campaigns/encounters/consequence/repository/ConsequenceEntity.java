package de.trauma.backend.campaigns.encounters.consequence.repository;

import de.trauma.backend.campaigns.encounters.consequence.domain.Consequence;
import de.trauma.backend.campaigns.encounters.encounter.repository.EncounterEntity;
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
public class ConsequenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "consequences")
    private List<EncounterEntity> encounters;

    public ConsequenceEntity(Consequence consequence) {
        this.id = consequence.getId();
        this.name = consequence.getName();
        this.description = consequence.getDescription();
        this.encounters = consequence.getEncounters().stream().map(EncounterEntity::new).toList();
    }
}
