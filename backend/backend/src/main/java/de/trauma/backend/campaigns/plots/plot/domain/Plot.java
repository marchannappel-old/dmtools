package de.trauma.backend.campaigns.plots.plot.domain;

import de.trauma.backend.campaigns.campaign.domain.Campaign;
import de.trauma.backend.campaigns.encounters.encounter.domain.Encounter;
import de.trauma.backend.campaigns.plots.plot.repository.PlotEntity;
import de.trauma.backend.campaigns.plots.plottype.domain.PlotType;
import de.trauma.backend.campaigns.plots.theme.domain.Theme;
import de.trauma.backend.characters.charactertype.domain.CharacterType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
}
