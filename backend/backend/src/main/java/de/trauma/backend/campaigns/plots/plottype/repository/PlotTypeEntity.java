package de.trauma.backend.campaigns.plots.plottype.repository;

import de.trauma.backend.campaigns.plots.plot.repository.PlotEntity;
import de.trauma.backend.campaigns.plots.plottype.domain.PlotType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class PlotTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "plotType")
    private List<PlotEntity> plots;

    public PlotTypeEntity() {
    }

    public PlotTypeEntity(PlotType plotType) {
        this.id = plotType.getId();
        this.name = plotType.getName();
        this.description = plotType.getDescription();
        this.plots = plotType.getPlots().stream().map(PlotEntity::new).toList();
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
