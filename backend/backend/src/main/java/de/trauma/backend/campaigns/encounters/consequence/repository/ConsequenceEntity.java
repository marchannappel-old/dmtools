package de.trauma.backend.campaigns.encounters.consequence.repository;

import de.trauma.backend.campaigns.encounters.consequence.domain.Consequence;
import de.trauma.backend.campaigns.encounters.encounter.repository.EncounterEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
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

    public ConsequenceEntity() {
    }

    public ConsequenceEntity(Consequence consequence) {
        this.id = consequence.getId();
        this.name = consequence.getName();
        this.description = consequence.getDescription();
        this.encounters = consequence.getEncounters().stream().map(EncounterEntity::new).toList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EncounterEntity> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<EncounterEntity> encounters) {
        this.encounters = encounters;
    }
}
