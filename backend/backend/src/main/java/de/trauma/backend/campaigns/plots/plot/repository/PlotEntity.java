package de.trauma.backend.campaigns.plots.plot.repository;

import de.trauma.backend.campaigns.campaign.repository.CampaignEntity;
import de.trauma.backend.campaigns.encounters.encounter.repository.EncounterEntity;
import de.trauma.backend.campaigns.plots.plot.domain.Plot;
import de.trauma.backend.campaigns.plots.theme.repository.ThemeEntity;
import de.trauma.backend.campaigns.plots.plottype.repository.PlotTypeEntity;
import de.trauma.backend.characters.charactertype.repository.CharacterTypeEntity;
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
public class PlotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String pronunciation;

    @Column
    private String content;

    @Column
    private String objective;

    @Column
    private String focus;

    @Column
    private String expectations;

    @Column
    private String learning;

    @Column
    private String masterPlotChanges;

    @Column
    private String goal;

    @Column
    private String situation;

    @Column
    private String journey;

    @Column
    private String firstAttempt;

    @Column
    private String falseEnding;

    @Column
    private String climax;

    @ManyToMany
    @JoinTable(
            name = "plot_theme",
            joinColumns = @JoinColumn(name = "plot_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_id")
    )
    private List<ThemeEntity> theme;

    @ManyToMany
    @JoinTable(
            name = "plot_type",
            joinColumns = @JoinColumn(name = "plot_id"),
            inverseJoinColumns = @JoinColumn(name = "plottype_id")
    )
    private List<PlotTypeEntity> plotType;

    @ManyToMany
    @JoinTable(
            name = "plot_charactertype",
            joinColumns = @JoinColumn(name = "plot_id"),
            inverseJoinColumns = @JoinColumn(name = "charactertype_id")
    )
    private List<CharacterTypeEntity> adversaryType;

    @ManyToMany
    @JoinTable(
            name = "plot_encounter",
            joinColumns = @JoinColumn(name = "plot_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_id")
    )
    private List<EncounterEntity> encounters;

    @ManyToMany(mappedBy = "plots")
    private List<CampaignEntity> campaigns;

    public PlotEntity(Plot plot) {
        this.id = plot.getId();
        this.title = plot.getTitle();
        this.pronunciation = plot.getPronunciation();
        this.content = plot.getContent();
        this.objective = plot.getObjective();
        this.focus = plot.getFocus();
        this.expectations = plot.getExpectations();
        this.learning = plot.getLearning();
        this.masterPlotChanges = plot.getMasterPlotChanges();
        this.goal = plot.getGoal();
        this.situation = plot.getSituation();
        this.journey = plot.getJourney();
        this.firstAttempt = plot.getFirstAttempt();
        this.falseEnding = plot.getFalseEnding();
        this.climax = plot.getClimax();
        this.theme = plot.getTheme().stream().map(ThemeEntity::new).toList();
        this.plotType = plot.getPlotType().stream().map(PlotTypeEntity::new).toList();
        this.adversaryType = plot.getAdversaryType().stream().map(CharacterTypeEntity::new).toList();
        this.encounters = plot.getEncounters().stream().map(EncounterEntity::new).toList();
        this.campaigns = plot.getPlotType().stream().map(CampaignEntity::new).toList();
    }
}
