package de.trauma.backend.campaigns.plots.plot.domain;

import de.trauma.backend.campaigns.campaign.domain.Campaign;
import de.trauma.backend.campaigns.encounters.encounter.domain.Encounter;
import de.trauma.backend.campaigns.plots.plot.repository.PlotEntity;
import de.trauma.backend.campaigns.plots.plottype.domain.PlotType;
import de.trauma.backend.campaigns.plots.theme.domain.Theme;
import de.trauma.backend.characters.charactertype.domain.CharacterType;

import java.util.List;

public class Plot {
    private Long id;
    private String title;
    private String pronunciation;
    private String content;
    private String objective;
    private String focus;
    private String expectations;
    private String learning;
    private String masterPlotChanges;
    private String goal;
    private String situation;
    private String journey;
    private String firstAttempt;
    private String falseEnding;
    private String climax;
    private List<Theme> theme;
    private List<PlotType> plotType;
    private List<CharacterType> adversaryType;
    private List<Encounter> encounters;
    private List<Campaign> campaigns;

    public Plot(PlotEntity plot) {
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
        this.theme = plot.getTheme().stream().map(Theme::new).toList();
        this.plotType = plot.getPlotType().stream().map(PlotType::new).toList();
        this.adversaryType = plot.getAdversaryType().stream().map(CharacterType::new).toList();
        this.encounters = plot.getEncounters().stream().map(Encounter::new).toList();
        this.campaigns = plot.getCampaigns().stream().map(Campaign::new).toList();
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

    public List<Theme> getTheme() {
        return theme;
    }

    public void setTheme(List<Theme> theme) {
        this.theme = theme;
    }

    public List<PlotType> getPlotType() {
        return plotType;
    }

    public void setPlotType(List<PlotType> plotType) {
        this.plotType = plotType;
    }

    public List<CharacterType> getAdversaryType() {
        return adversaryType;
    }

    public void setAdversaryType(List<CharacterType> adversaryType) {
        this.adversaryType = adversaryType;
    }

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<Encounter> encounters) {
        this.encounters = encounters;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }
}
