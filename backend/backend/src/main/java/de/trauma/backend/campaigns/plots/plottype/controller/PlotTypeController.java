package de.trauma.backend.campaigns.plots.plottype.controller;

import de.trauma.backend.campaigns.plots.plottype.domain.PlotType;
import de.trauma.backend.campaigns.plots.plottype.service.PlotTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plottypes")
public class PlotTypeController {
    private final PlotTypeService plotTypeService;

    public PlotTypeController(PlotTypeService plotTypeService) {
        this.plotTypeService = plotTypeService;
    }

    @GetMapping
    public List<PlotTypeDTO> list() {
        return this.plotTypeService.findAllPlotTypes()
                .stream()
                .map(PlotTypeDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public PlotTypeDTO read(@PathVariable Long id) {
        return this.plotTypeService.findPlotTypeById(id)
                .map(PlotTypeDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public PlotTypeDTO create(@RequestBody PlotType plotType) {
        return new PlotTypeDTO(this.plotTypeService.createPlotType(plotType));
    }

    @PutMapping("/{id}")
    public PlotTypeDTO update(@PathVariable Long id, @RequestBody PlotType plotType) {
        return new PlotTypeDTO(this.plotTypeService.updatePlotType(id, plotType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.plotTypeService.deletePlotType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
