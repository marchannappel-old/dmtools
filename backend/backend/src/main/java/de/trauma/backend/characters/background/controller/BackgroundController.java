package de.trauma.backend.characters.background.controller;

import de.trauma.backend.characters.background.domain.Background;
import de.trauma.backend.characters.background.service.BackgroundService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backgrounds")
public class BackgroundController {
    private final BackgroundService backgroundService;

    public BackgroundController(BackgroundService backgroundService) {
        this.backgroundService = backgroundService;
    }

    @GetMapping
    public List<BackgroundDTO> list() {
        return this.backgroundService.findAllBackgrounds()
                .stream()
                .map(BackgroundDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public BackgroundDTO read(@PathVariable Long id) {
        return this.backgroundService.findBackgroundById(id)
                .map(BackgroundDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public BackgroundDTO create(@RequestBody Background background) {
        return new BackgroundDTO(this.backgroundService.createBackground(background));
    }

    @PutMapping("/{id}")
    public BackgroundDTO update(@PathVariable Long id, @RequestBody Background background) {
        return new BackgroundDTO(this.backgroundService.updateBackground(id, background));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.backgroundService.deleteBackground(id);
        return new ResponseEntity<>(HttpStatus.OK)
    }
}
