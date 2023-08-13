package de.trauma.backend.campaigns.plots.plottype.controller;

import de.trauma.backend.campaigns.plots.plottype.domain.PlotType;
import de.trauma.backend.campaigns.plots.plottype.service.PlotTypeService;
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

    }

    @GetMapping("/{id}")
    public PlotTypeDTO read(@PathVariable Long id) {

    }

    @PostMapping
    public PlotTypeDTO create(@RequestBody PlotType theme) {

    }

    @PutMapping("/{id}")
    public PlotTypeDTO update(@PathVariable Long id, @RequestBody PlotType theme) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

    }
}
