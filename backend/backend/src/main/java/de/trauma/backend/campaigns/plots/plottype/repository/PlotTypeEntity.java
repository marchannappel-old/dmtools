package de.trauma.backend.campaigns.plots.plottype.repository;

import de.trauma.backend.campaigns.plots.plot.repository.PlotEntity;
import de.trauma.backend.campaigns.plots.plottype.domain.PlotType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
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

    public PlotTypeEntity(PlotType plotType) {
        this.id = plotType.getId();
        this.name = plotType.getName();
        this.description = plotType.getDescription();
        this.plots = plotType.getPlots().stream().map(PlotEntity::new).toList();
    }
}
