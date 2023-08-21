package de.trauma.backend.characters.languages.controller;

import de.trauma.backend.characters.languages.domain.Language;
import de.trauma.backend.characters.languages.service.LanguageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public List<LanguageDTO> list() {
        return this.languageService.findAllLanguages()
                .stream()
                .map(LanguageDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public LanguageDTO read(@PathVariable Long id) {
        return this.languageService.findLanguageById(id)
                .map(LanguageDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public LanguageDTO create(@RequestBody Language language) {
        return new LanguageDTO(this.languageService.createLanguage(language));
    }

    @PutMapping("/{id}")
    public LanguageDTO update(@PathVariable Long id, @RequestBody Language language) {
        return new LanguageDTO(this.languageService.updateLanguage(id, language));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.languageService.deleteLanguage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
