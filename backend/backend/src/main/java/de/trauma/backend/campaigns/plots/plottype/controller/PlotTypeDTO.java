package de.trauma.backend.campaigns.plots.plottype.controller;

import de.trauma.backend.campaigns.plots.plot.controller.PlotDTO;
import de.trauma.backend.campaigns.plots.plottype.domain.PlotType;
import lombok.Getter;

import java.util.List;

@Getter
public class PlotTypeDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<PlotDTO> plots;

    public PlotTypeDTO(PlotType plotType) {
        this.id = plotType.getId();
        this.name = plotType.getName();
        this.description = plotType.getName();
        this.plots = plotType.getPlots().stream().map(PlotDTO::new).toList();
    }
}
