package de.trauma.backend.campaigns.plots.plottype.service;

import de.trauma.backend.campaigns.plots.plottype.domain.PlotType;
import de.trauma.backend.campaigns.plots.plottype.exceptions.PlotTypeNotFoundException;
import de.trauma.backend.campaigns.plots.plottype.repository.PlotTypeEntity;
import de.trauma.backend.campaigns.plots.plottype.repository.PlotTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlotTypeService {
    private final PlotTypeRepository plotTypeRepository;

    public PlotTypeService(PlotTypeRepository plotTypeRepository) {
        this.plotTypeRepository = plotTypeRepository;
    }

    public List<PlotType> findAllPlotTypes() {
        return this.plotTypeRepository.findAll()
                .stream()
                .map(PlotType::new)
                .toList();
    }

    public Optional<PlotType> findPlotTypeById(Long id) {
        return this.plotTypeRepository.findById(id)
                .map(PlotType::new);
    }

    public PlotType createPlotType(PlotType plotType) {
        return new PlotType(this.plotTypeRepository.save(new PlotTypeEntity(plotType)));
    }

    public PlotType updatePlotType(Long id, PlotType plotType) {
        Optional<PlotType> existingPlotType = this.plotTypeRepository.findById(id)
                .map(PlotType::new);

        if (existingPlotType.isPresent()) {
            PlotType updatedPlotType = existingPlotType.get();
            updatedPlotType.setId(plotType.getId());
            updatedPlotType.setName(plotType.getName());
            updatedPlotType.setDescription(plotType.getDescription());
            updatedPlotType.setPlots(plotType.getPlots());

            return new PlotType(this.plotTypeRepository.save(new PlotTypeEntity(updatedPlotType)));
        }
        else {
            throw new PlotTypeNotFoundException("PlotType could not be found with id: " + id);
        }
    }

    public void deletePlotType(Long id) {
        this.plotTypeRepository.deleteById(id);
    }
}
