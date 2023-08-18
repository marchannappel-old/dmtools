package de.trauma.backend.characters.charactertype.controller;

import de.trauma.backend.characters.charactertype.domain.CharacterType;
import de.trauma.backend.characters.charactertype.service.CharacterTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/charactertypes")
public class CharacterTypeController {
    private final CharacterTypeService characterTypeService;

    public CharacterTypeController(CharacterTypeService characterTypeService) {
        this.characterTypeService = characterTypeService;
    }


    @GetMapping
    public List<CharacterTypeDTO> list() {
        return this.characterTypeService.findAllCharacterTypes()
                .stream()
                .map(CharacterTypeDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public CharacterTypeDTO read(@PathVariable Long id) {
        return this.characterTypeService.findCharacterTypeById(id)
                .map(CharacterTypeDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public CharacterTypeDTO create(@RequestBody CharacterType type) {
        return new CharacterTypeDTO(this.characterTypeService.createCharacterType(type));
    }

    @PutMapping("/{id}")
    public CharacterTypeDTO update(@PathVariable Long id, @RequestBody CharacterType type) {
        return new CharacterTypeDTO(this.characterTypeService.updateCharacterType(id, type));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.characterTypeService.deleteCharacterType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
