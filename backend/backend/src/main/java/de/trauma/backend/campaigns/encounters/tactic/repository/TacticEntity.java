package de.trauma.backend.campaigns.encounters.tactic.repository;

import de.trauma.backend.campaigns.encounters.encounter.repository.EncounterEntity;
import de.trauma.backend.campaigns.encounters.tactic.domain.Tactic;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class TacticEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "tactics")
    private List<EncounterEntity> encounters;

    public TacticEntity() {
    }

    public TacticEntity(Tactic tactic) {
        this.id = tactic.getId();
        this.name = tactic.getName();
        this.description = tactic.getDescription();
        this.encounters = tactic.getEncounters().stream().map(EncounterEntity::new).toList();
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
