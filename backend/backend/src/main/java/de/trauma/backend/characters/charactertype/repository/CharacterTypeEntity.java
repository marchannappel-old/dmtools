package de.trauma.backend.characters.charactertype.repository;

import de.trauma.backend.campaigns.plots.plot.repository.PlotEntity;
import de.trauma.backend.characters.charactertype.domain.CharacterType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class CharacterTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "adversaryType")
    private List<PlotEntity> plots;

    public CharacterTypeEntity() {
    }

    public CharacterTypeEntity(CharacterType characterType) {
        this.id = characterType.getId();
        this.name = characterType.getName();
        this.description = characterType.getDescription();
        this.plots = characterType.getPlots().stream().map(PlotEntity::new).toList();
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

    public List<PlotEntity> getPlots() {
        return plots;
    }

    public void setPlots(List<PlotEntity> plots) {
        this.plots = plots;
    }
}
