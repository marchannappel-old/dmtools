package de.trauma.backend.characters.proficiency.controller;

import de.trauma.backend.characters.proficiency.domain.Proficiency;
import de.trauma.backend.characters.proficiency.service.ProficiencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proficiencies")
public class ProficiencyController {
    private final ProficiencyService proficiencyService;

    public ProficiencyController(ProficiencyService proficiencyService) {
        this.proficiencyService = proficiencyService;
    }

    @GetMapping
    public List<ProficiencyDTO> list() {
        return this.proficiencyService.findAllProficiencies()
                .stream()
                .map(ProficiencyDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ProficiencyDTO read(@PathVariable Long id) {
        return this.proficiencyService.findProficiencyById(id)
                .map(ProficiencyDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public ProficiencyDTO create(@RequestBody Proficiency proficiency) {
        return new ProficiencyDTO(this.proficiencyService.createProficiency(proficiency));
    }

    @PutMapping("/{id}")
    public ProficiencyDTO update(@PathVariable Long id, @RequestBody Proficiency proficiency) {
        return new ProficiencyDTO(this.proficiencyService.updateProficiency(id, proficiency));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.proficiencyService.deleteProficiency(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
