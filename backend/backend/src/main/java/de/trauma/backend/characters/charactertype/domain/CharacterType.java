package de.trauma.backend.characters.charactertype.domain;

import de.trauma.backend.campaigns.plots.plot.domain.Plot;
import de.trauma.backend.characters.charactertype.repository.CharacterTypeEntity;

import java.util.List;

public class CharacterType {
    private Long id;
    private String name;
    private String description;
    private List<Plot> plots;

    public CharacterType(CharacterTypeEntity characterType) {
        this.id = characterType.getId();
        this.name = characterType.getName();
        this.description = characterType.getDescription();
        this.plots = characterType.getPlots().stream().map(Plot::new).toList();
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

    public List<Plot> getPlots() {
        return plots;
    }

    public void setPlots(List<Plot> plots) {
        this.plots = plots;
    }
}
