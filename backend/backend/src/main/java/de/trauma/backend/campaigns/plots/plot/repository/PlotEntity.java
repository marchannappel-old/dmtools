package de.trauma.backend.campaigns.plots.plot.repository;

import de.trauma.backend.campaigns.campaign.repository.CampaignEntity;
import de.trauma.backend.campaigns.encounters.encounter.repository.EncounterEntity;
import de.trauma.backend.campaigns.plots.plot.domain.Plot;
import de.trauma.backend.campaigns.plots.theme.repository.ThemeEntity;
import de.trauma.backend.campaigns.plots.plottype.repository.PlotTypeEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
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

    public PlotEntity() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getExpectations() {
        return expectations;
    }

    public void setExpectations(String expectations) {
        this.expectations = expectations;
    }

    public String getLearning() {
        return learning;
    }

    public void setLearning(String learning) {
        this.learning = learning;
    }

    public String getMasterPlotChanges() {
        return masterPlotChanges;
    }

    public void setMasterPlotChanges(String masterPlotChanges) {
        this.masterPlotChanges = masterPlotChanges;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getJourney() {
        return journey;
    }

    public void setJourney(String journey) {
        this.journey = journey;
    }

    public String getFirstAttempt() {
        return firstAttempt;
    }

    public void setFirstAttempt(String firstAttempt) {
        this.firstAttempt = firstAttempt;
    }

    public String getFalseEnding() {
        return falseEnding;
    }

    public void setFalseEnding(String falseEnding) {
        this.falseEnding = falseEnding;
    }

    public String getClimax() {
        return climax;
    }

    public void setClimax(String climax) {
        this.climax = climax;
    }

    public List<ThemeEntity> getTheme() {
        return theme;
    }

    public void setTheme(List<ThemeEntity> theme) {
        this.theme = theme;
    }

    public List<PlotTypeEntity> getPlotType() {
        return plotType;
    }

    public void setPlotType(List<PlotTypeEntity> plotType) {
        this.plotType = plotType;
    }

    public List<CharacterTypeEntity> getAdversaryType() {
        return adversaryType;
    }

    public void setAdversaryType(List<CharacterTypeEntity> adversaryType) {
        this.adversaryType = adversaryType;
    }

    public List<EncounterEntity> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<EncounterEntity> encounters) {
        this.encounters = encounters;
    }

    public List<CampaignEntity> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<CampaignEntity> campaigns) {
        this.campaigns = campaigns;
    }
}
