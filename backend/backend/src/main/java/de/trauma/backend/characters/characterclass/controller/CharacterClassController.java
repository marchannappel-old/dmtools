package de.trauma.backend.characters.characterclass.controller;

import de.trauma.backend.characters.characterclass.domain.CharacterClass;
import de.trauma.backend.characters.characterclass.service.CharacterClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class CharacterClassController {
    private final CharacterClassService characterClassService;

    public CharacterClassController(CharacterClassService characterClassService) {
        this.characterClassService = characterClassService;
    }

    @GetMapping
    public List<CharacterClassDTO> list() {
        return this.characterClassService.findAllClasses()
                .stream()
                .map(CharacterClassDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public CharacterClassDTO read(@PathVariable Long id) {
        return this.characterClassService.findClassById(id)
                .map(CharacterClassDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public CharacterClassDTO create(@RequestBody CharacterClass characterClass) {
        return new CharacterClassDTO(this.characterClassService.createClass(characterClass));
    }

    @PutMapping("/{id}")
    public CharacterClassDTO update(@PathVariable Long id, @RequestBody CharacterClass characterClass) {
        return new CharacterClassDTO(this.characterClassService.updateClass(id, characterClass));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.characterClassService.deleteClass(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
