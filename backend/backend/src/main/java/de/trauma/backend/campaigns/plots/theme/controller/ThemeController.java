package de.trauma.backend.campaigns.plots.theme.controller;

import de.trauma.backend.campaigns.plots.theme.domain.Theme;
import de.trauma.backend.campaigns.plots.theme.service.ThemeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/themes")
public class ThemeController {
    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping
    public List<ThemeDTO> list() {

    }

    @GetMapping("/{id}")
    public ThemeDTO read(@PathVariable Long id) {

    }

    @PostMapping
    public ThemeDTO create(@RequestBody Theme theme) {

    }

    @PutMapping("/{id}")
    public ThemeDTO update(@PathVariable Long id, @RequestBody Theme theme) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

    }
}
