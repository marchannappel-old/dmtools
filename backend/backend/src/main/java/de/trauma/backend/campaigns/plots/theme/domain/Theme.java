package de.trauma.backend.campaigns.plots.theme.domain;

import de.trauma.backend.campaigns.plots.plot.domain.Plot;
import de.trauma.backend.campaigns.plots.theme.repository.ThemeEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
}
