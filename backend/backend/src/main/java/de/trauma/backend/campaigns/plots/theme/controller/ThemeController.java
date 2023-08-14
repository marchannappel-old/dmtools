package de.trauma.backend.campaigns.plots.theme.controller;

import de.trauma.backend.campaigns.plots.theme.domain.Theme;
import de.trauma.backend.campaigns.plots.theme.service.ThemeService;
import org.springframework.http.HttpStatus;
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
        return this.themeService.findAllThemes()
                .stream()
                .map(ThemeDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ThemeDTO read(@PathVariable Long id) {
        return this.themeService.findThemeById(id)
                .map(ThemeDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public ThemeDTO create(@RequestBody Theme theme) {
        return new ThemeDTO(this.themeService.createTheme(theme));
    }

    @PutMapping("/{id}")
    public ThemeDTO update(@PathVariable Long id, @RequestBody Theme theme) {
        return new ThemeDTO(this.themeService.updateTheme(id, theme));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.themeService.deleteTheme(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
