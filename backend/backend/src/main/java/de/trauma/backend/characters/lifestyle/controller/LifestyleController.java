package de.trauma.backend.characters.lifestyle.controller;

import de.trauma.backend.characters.lifestyle.domain.Lifestyle;
import de.trauma.backend.characters.lifestyle.service.LifestyleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lifestyles")
public class LifestyleController {
    private final LifestyleService lifestyleService;

    public LifestyleController(LifestyleService lifestyleService) {
        this.lifestyleService = lifestyleService;
    }

    @GetMapping
    public List<LifestyleDTO> list() {
        return this.lifestyleService.findAllLifestyles()
                .stream()
                .map(LifestyleDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public LifestyleDTO read(@PathVariable Long id) {
        return this.lifestyleService.findLifestyleById(id)
                .map(LifestyleDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public LifestyleDTO create(@RequestBody Lifestyle lifestyle) {
        return new LifestyleDTO(this.lifestyleService.createLifestyle(lifestyle));
    }

    @PutMapping("/{id}")
    public LifestyleDTO update(@PathVariable Long id, @RequestBody Lifestyle lifestyle) {
        return new LifestyleDTO(this.lifestyleService.updateLifestyle(id, lifestyle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.lifestyleService.deleteLifestyle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
