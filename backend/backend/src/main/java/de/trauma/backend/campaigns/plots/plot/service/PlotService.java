package de.trauma.backend.campaigns.plots.plot.service;

import de.trauma.backend.campaigns.plots.plot.domain.Plot;
import de.trauma.backend.campaigns.plots.plot.exceptions.PlotNotFoundException;
import de.trauma.backend.campaigns.plots.plot.repository.PlotEntity;
import de.trauma.backend.campaigns.plots.plot.repository.PlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlotService {
    private final PlotRepository plotRepository;

    public PlotService(PlotRepository plotRepository) {
        this.plotRepository = plotRepository;
    }

    public List<Plot> findAllPlots() {
        return this.plotRepository.findAll()
                .stream()
                .map(Plot::new)
                .toList();
    }

    public Optional<Plot> findPlotById(Long id) {
        return this.plotRepository.findById(id)
                .map(Plot::new);
    }

    public Plot createPlot(Plot plot) {
        return new Plot(this.plotRepository.save(new PlotEntity(plot)));
    }

    public Plot updatePlot(Long id, Plot plot) {
        Optional<Plot> existingPlot = this.plotRepository.findById(id)
                .map(Plot::new);

        if (existingPlot.isPresent()) {
            Plot updatedPlot = existingPlot.get();
            updatedPlot.setId(plot.getId());
            updatedPlot.setTitle(plot.getTitle());
            updatedPlot.setPronunciation(plot.getPronunciation());
            updatedPlot.setContent(plot.getContent());
            updatedPlot.setObjective(plot.getObjective());
            updatedPlot.setFocus(plot.getFocus());
            updatedPlot.setExpectations(plot.getExpectations());
            updatedPlot.setLearning(plot.getLearning());
            updatedPlot.setMasterPlotChanges(plot.getMasterPlotChanges());
            updatedPlot.setGoal(plot.getGoal());
            updatedPlot.setSituation(plot.getSituation());
            updatedPlot.setJourney(plot.getJourney());
            updatedPlot.setFirstAttempt(plot.getFirstAttempt());
            updatedPlot.setFalseEnding(plot.getFalseEnding());
            updatedPlot.setClimax(plot.getClimax());
            updatedPlot.setTheme(plot.getTheme());
            updatedPlot.setPlotType(plot.getPlotType());
            updatedPlot.setAdversaryType(plot.getAdversaryType());
            updatedPlot.setEncounters(plot.getEncounters());
            updatedPlot.setCampaigns(plot.getCampaigns());

            return new Plot(this.plotRepository.save(new PlotEntity(updatedPlot)));
        }
        else {
            throw new PlotNotFoundException("Plot could not be found with id: " + id);
        }
    }

    public void deletePlot(Long id) {
        this.plotRepository.deleteById(id);
    }
}
