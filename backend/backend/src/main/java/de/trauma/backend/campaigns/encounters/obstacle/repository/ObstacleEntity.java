package de.trauma.backend.campaigns.encounters.obstacle.repository;

import de.trauma.backend.campaigns.encounters.encounter.repository.EncounterEntity;
import de.trauma.backend.campaigns.encounters.obstacle.domain.Obstacle;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ObstacleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String pronunciation;

    @ManyToMany(mappedBy = "obstacles")
    private List<EncounterEntity> encounters;

    public ObstacleEntity() {
    }

    public ObstacleEntity(Obstacle obstacle) {
        this.id = obstacle.getId();
        this.name = obstacle.getName();
        this.description = obstacle.getDescription();
        this.pronunciation = obstacle.getPronunciation();
        this.encounters = obstacle.getEncounters().stream().map(EncounterEntity::new).toList();
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

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public List<EncounterEntity> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<EncounterEntity> encounters) {
        this.encounters = encounters;
    }
}
