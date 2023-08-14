package de.trauma.backend.campaigns.plots.theme.controller;

import de.trauma.backend.campaigns.plots.plot.controller.PlotDTO;
import de.trauma.backend.campaigns.plots.theme.domain.Theme;

import java.util.List;

public class ThemeDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<PlotDTO> plots;

    public ThemeDTO(Theme theme) {
        this.id = theme.getId();
        this.name = theme.getName();
        this.description = theme.getDescription();
        this.plots = theme.getPlots().stream().map(PlotDTO::new).toList();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<PlotDTO> getPlots() {
        return plots;
    }
}
