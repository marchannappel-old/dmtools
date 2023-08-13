package de.trauma.backend.campaigns.encounters.consequence.controller;

import de.trauma.backend.campaigns.encounters.consequence.domain.Consequence;
import de.trauma.backend.campaigns.encounters.consequence.service.ConsequenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consequences")
public class ConsequenceController {
    private final ConsequenceService consequenceService;

    public ConsequenceController(ConsequenceService consequenceService) {
        this.consequenceService = consequenceService;
    }

    @GetMapping
    public List<ConsequenceDTO> list() {
        return this.consequenceService.findAllConsequences()
                .stream()
                .map(ConsequenceDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ConsequenceDTO read(@PathVariable Long id) {
        return this.consequenceService.findConsequenceById(id)
                .map(ConsequenceDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public ConsequenceDTO create(@RequestBody Consequence consequence) {
        return new ConsequenceDTO(this.consequenceService.createConsequence(consequence));
    }

    @PutMapping("/{id}")
    public ConsequenceDTO update(@PathVariable Long id, @RequestBody Consequence consequence) {
        return new ConsequenceDTO(this.consequenceService.updateConsequence(id, consequence));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.consequenceService.deleteConsequence(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
