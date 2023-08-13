package de.trauma.backend.campaigns.plots.theme.repository;

import de.trauma.backend.campaigns.campaign.repository.CampaignEntity;
import de.trauma.backend.campaigns.plots.plot.repository.PlotEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ThemeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "theme")
    private List<PlotEntity> plots;

    public ThemeEntity() {
    }
}
