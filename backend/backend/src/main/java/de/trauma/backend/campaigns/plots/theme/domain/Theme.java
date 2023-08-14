package de.trauma.backend.campaigns.plots.theme.domain;

import de.trauma.backend.campaigns.plots.plot.domain.Plot;
import de.trauma.backend.campaigns.plots.theme.repository.ThemeEntity;

import java.util.List;

public class Theme {
    private Long id;
    private String name;
    private String description;
    private List<Plot> plots;

    public Theme(ThemeEntity theme) {
        this.id = theme.getId();
        this.name = theme.getName();
        this.description = theme.getDescription();
        this.plots = theme.getPlots().stream().map(Plot::new).toList();
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
