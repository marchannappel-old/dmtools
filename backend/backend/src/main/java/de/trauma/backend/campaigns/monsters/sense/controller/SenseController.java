package de.trauma.backend.campaigns.monsters.sense.controller;

import de.trauma.backend.campaigns.monsters.sense.domain.Sense;
import de.trauma.backend.campaigns.monsters.sense.service.SenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/senses")
public class SenseController {
    private final SenseService senseService;

    public SenseController(SenseService senseService) {
        this.senseService = senseService;
    }

    @GetMapping
    public List<SenseDTO> list() {
        return this.senseService.findAllSenses()
                .stream()
                .map(SenseDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public SenseDTO read(@PathVariable Long id) {
        return this.senseService.findSenseById(id)
                .map(SenseDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public SenseDTO create(@RequestBody Sense sense) {
        return new SenseDTO(this.senseService.createSense(sense));
    }

    @PutMapping("/{id}")
    public SenseDTO update(@PathVariable Long id, @RequestBody Sense sense) {
        return new SenseDTO(this.senseService.updateSense(id, sense));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.senseService.deleteSense(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
