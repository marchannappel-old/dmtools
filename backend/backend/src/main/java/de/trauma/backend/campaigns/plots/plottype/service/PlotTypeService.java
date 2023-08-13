package de.trauma.backend.campaigns.plots.plottype.service;

import de.trauma.backend.campaigns.plots.plottype.domain.PlotType;
import de.trauma.backend.campaigns.plots.plottype.repository.PlotTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlotTypeService {
    private final PlotTypeRepository plotTypeRepository;

    public PlotTypeService(PlotTypeRepository plotTypeRepository) {
        this.plotTypeRepository = plotTypeRepository;
    }

    public List<PlotType> findAllPlotTypes() {

    }

    public PlotType findPlotTypeById(Long id) {

    }

    public PlotType createPlotType(PlotType theme) {

    }

    public PlotType updatePlotType(Long id, PlotType theme) {

    }

    public void deletePlotType(Long id) {

    }
}
