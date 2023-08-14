package de.trauma.backend.campaigns.encounters.encounter.controller;

import de.trauma.backend.campaigns.encounters.encounter.domain.Encounter;
import de.trauma.backend.campaigns.encounters.encounter.service.EncounterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/encounters")
public class EncounterController {
    private final EncounterService encounterService;

    public EncounterController(EncounterService encounterService) {
        this.encounterService = encounterService;
    }

    @GetMapping
    public List<EncounterDTO> list() {
        return this.encounterService.findAllEncounters()
                .stream()
                .map(EncounterDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public EncounterDTO read(@PathVariable Long id) {
        return this.encounterService.findEncounterById(id)
                .map(EncounterDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public EncounterDTO create(@RequestBody Encounter encounter) {
        return new EncounterDTO(this.encounterService.createEncounter(encounter));
    }

    @PutMapping("/{id}")
    public EncounterDTO update(@PathVariable Long id, @RequestBody Encounter encounter) {
        return new EncounterDTO(this.encounterService.updateEncounter(id, encounter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.encounterService.deleteEncounter(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
