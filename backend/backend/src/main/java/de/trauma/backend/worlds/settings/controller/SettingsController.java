package de.trauma.backend.worlds.settings.controller;

import de.trauma.backend.worlds.settings.domain.Settings;
import de.trauma.backend.worlds.settings.service.SettingsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worldsettings")
public class SettingsController {
    private final SettingsService settingsService;

    public SettingsController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @GetMapping
    public List<SettingsDTO> list() {
        return this.settingsService.findAllSettings()
                .stream()
                .map(SettingsDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public SettingsDTO read(@PathVariable Long id, @RequestBody Settings settings) {
        return this.settingsService.findSettingById(id)
                .map(SettingsDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public SettingsDTO create(@RequestBody Settings settings) {
        return new SettingsDTO(this.settingsService.createSettings(settings));
    }

    @PutMapping("/{id}")
    public SettingsDTO update(@PathVariable Long id, @RequestBody Settings settings) {
        return new SettingsDTO(this.settingsService.updateSettings(id, settings));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.settingsService.deleteSettings(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
