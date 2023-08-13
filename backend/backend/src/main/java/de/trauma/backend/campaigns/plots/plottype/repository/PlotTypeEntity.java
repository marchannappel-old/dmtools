package de.trauma.backend.campaigns.plots.plottype.repository;

import de.trauma.backend.campaigns.plots.plot.repository.PlotEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class PlotTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "plotType")
    private List<PlotEntity> plots;

    public PlotTypeEntity() {
    }
}
