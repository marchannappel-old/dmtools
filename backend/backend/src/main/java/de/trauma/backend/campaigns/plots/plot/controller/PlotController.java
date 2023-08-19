package de.trauma.backend.campaigns.plots.plot.controller;

import de.trauma.backend.campaigns.plots.plot.domain.Plot;
import de.trauma.backend.campaigns.plots.plot.service.PlotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plots")
public class PlotController {
    private final PlotService plotService;

    public PlotController(PlotService plotService) {
        this.plotService = plotService;
    }

    @GetMapping
    public List<PlotDTO> list() {
        return this.plotService.findAllPlots()
                .stream()
                .map(PlotDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public PlotDTO read(@PathVariable Long id) {
        return this.plotService.findPlotById(id)
                .map(PlotDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public PlotDTO create(@RequestBody Plot plot) {
        return new PlotDTO(this.plotService.createPlot(plot));
    }

    @PutMapping("/{id}")
    public PlotDTO update(@PathVariable Long id, @RequestBody Plot plot) {
        return new PlotDTO(this.plotService.updatePlot(id, plot));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.plotService.deletePlot(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
