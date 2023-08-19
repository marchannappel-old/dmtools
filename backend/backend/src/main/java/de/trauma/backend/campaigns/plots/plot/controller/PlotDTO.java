package de.trauma.backend.campaigns.plots.plot.controller;

import de.trauma.backend.campaigns.campaign.controller.CampaignDTO;
import de.trauma.backend.campaigns.encounters.encounter.controller.EncounterDTO;
import de.trauma.backend.campaigns.plots.plot.domain.Plot;
import de.trauma.backend.campaigns.plots.plottype.controller.PlotTypeDTO;
import de.trauma.backend.campaigns.plots.theme.controller.ThemeDTO;
import de.trauma.backend.characters.charactertype.controller.CharacterTypeDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class PlotDTO {
    private final Long id;
    private final String title;
    private final String pronunciation;
    private final String content;
    private final String objective;
    private final String focus;
    private final String expectations;
    private final String learning;
    private final String masterPlotChanges;
    private final String goal;
    private final String situation;
    private final String journey;
    private final String firstAttempt;
    private final String falseEnding;
    private final String climax;
    private final List<ThemeDTO> theme;
    private final List<PlotTypeDTO> plotType;
    private final List<CharacterTypeDTO> adversaryType;
    private final List<EncounterDTO> encounters;
    private final List<CampaignDTO> campaigns;

    public PlotDTO(Plot plot) {
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
        this.theme = plot.getTheme().stream().map(ThemeDTO::new).toList();
        this.plotType = plot.getPlotType().stream().map(PlotTypeDTO::new).toList();
        this.adversaryType = plot.getAdversaryType().stream().map(CharacterTypeDTO::new).toList();
        this.encounters = plot.getEncounters().stream().map(EncounterDTO::new).toList();
        this.campaigns = plot.getCampaigns().stream().map(CampaignDTO::new).toList();
    }
}
