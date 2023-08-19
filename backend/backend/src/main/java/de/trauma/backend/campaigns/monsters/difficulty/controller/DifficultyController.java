package de.trauma.backend.campaigns.monsters.difficulty.controller;

import de.trauma.backend.campaigns.monsters.difficulty.domain.Difficulty;
import de.trauma.backend.campaigns.monsters.difficulty.service.DifficultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/difficulties")
public class DifficultyController {
    private final DifficultyService difficultyService;

    public DifficultyController(DifficultyService difficultyService) {
        this.difficultyService = difficultyService;
    }

    @GetMapping
    public List<DifficultyDTO> list() {
        return this.difficultyService.findAllDifficulties()
                .stream()
                .map(DifficultyDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public DifficultyDTO read(@PathVariable Long id) {
        return this.difficultyService.findDifficultyById(id)
                .map(DifficultyDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public DifficultyDTO create(@RequestBody Difficulty difficulty) {
        return new DifficultyDTO(this.difficultyService.createDifficulty(difficulty));
    }

    @PutMapping("/{id}")
    public DifficultyDTO update(@PathVariable Long id, @RequestBody Difficulty difficulty) {
        return new DifficultyDTO(this.difficultyService.updateDifficulty(id, difficulty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.difficultyService.deleteDifficulty(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
