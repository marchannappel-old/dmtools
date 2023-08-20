package de.trauma.backend.characters.ability.controller;

import de.trauma.backend.characters.ability.domain.Ability;
import de.trauma.backend.characters.ability.service.AbilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abilities")
public class AbilityController {
    private final AbilityService abilityService;

    public AbilityController(AbilityService abilityService) {
        this.abilityService = abilityService;
    }

    @GetMapping
    public List<AbilityDTO> list() {
        return this.abilityService.findAllAbilities()
                .stream()
                .map(AbilityDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public AbilityDTO read(@PathVariable Long id) {
        return this.abilityService.findAbilityById(id)
                .map(AbilityDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public AbilityDTO create(@RequestBody Ability ability) {
        return new AbilityDTO(this.abilityService.createAbility(ability));
    }

    @PutMapping("/{id}")
    public AbilityDTO update(@PathVariable Long id, @RequestBody Ability ability) {
        return new AbilityDTO(this.abilityService.updateAbility(id, ability));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.abilityService.deleteAbility(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
