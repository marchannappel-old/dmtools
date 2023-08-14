package de.trauma.backend.campaigns.plots.theme.repository;

import de.trauma.backend.campaigns.plots.plot.repository.PlotEntity;
import de.trauma.backend.campaigns.plots.theme.domain.Theme;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ThemeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "theme")
    private List<PlotEntity> plots;

    public ThemeEntity() {
    }

    public ThemeEntity(Theme theme) {
        this.id = theme.getId();
        this.name = theme.getName();
        this.description = theme.getDescription();
        this.plots = theme.getPlots().stream().map(PlotEntity::new).toList();
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
