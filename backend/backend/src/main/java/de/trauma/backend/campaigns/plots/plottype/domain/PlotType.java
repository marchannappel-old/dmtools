package de.trauma.backend.campaigns.plots.plottype.domain;

import de.trauma.backend.campaigns.plots.plot.domain.Plot;
import de.trauma.backend.campaigns.plots.plottype.repository.PlotTypeEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlotType {
    private Long id;
    private String name;
    private String description;
    private List<Plot> plots;

    public PlotType(PlotTypeEntity plotType) {
        this.id = plotType.getId();
        this.name = plotType.getName();
        this.description = plotType.getDescription();
        this.plots = plotType.getPlots().stream().map(Plot::new).toList();
    }
}
