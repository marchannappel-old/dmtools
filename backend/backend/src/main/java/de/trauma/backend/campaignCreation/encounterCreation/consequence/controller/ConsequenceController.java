package de.trauma.backend.campaignCreation.encounterCreation.consequence.controller;

import de.trauma.backend.campaignCreation.encounterCreation.consequence.domain.Consequence;
import de.trauma.backend.campaignCreation.encounterCreation.consequence.service.ConsequenceService;
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

    }

    @GetMapping("/{id}")
    public ConsequenceDTO read(@PathVariable Long id) {

    }

    @PostMapping
    public ConsequenceDTO create(@RequestBody Consequence consequence) {

    }

    @PutMapping("/{id}")
    public ConsequenceDTO update(@PathVariable Long id, @RequestBody Consequence consequence) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

    }
}
