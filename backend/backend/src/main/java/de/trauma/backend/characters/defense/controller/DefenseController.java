package de.trauma.backend.characters.defense.controller;

import de.trauma.backend.characters.defense.domain.Defense;
import de.trauma.backend.characters.defense.service.DefenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/defenses")
public class DefenseController {
    private final DefenseService defenseService;

    public DefenseController(DefenseService defenseService) {
        this.defenseService = defenseService;
    }

    @GetMapping
    public List<DefenseDTO> list() {
        return this.defenseService.findAllDefenses()
                .stream()
                .map(DefenseDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public DefenseDTO read(@PathVariable Long id) {
        return this.defenseService.findDefenseById(id)
                .map(DefenseDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public DefenseDTO create(@RequestBody Defense defense) {
        return new DefenseDTO(this.defenseService.createDefense(defense));
    }

    @PutMapping("/{id}")
    public DefenseDTO update(@PathVariable Long id, @RequestBody Defense defense) {
        return new DefenseDTO(this.defenseService.updateDefense(id, defense));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.defenseService.deleteDefense(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
