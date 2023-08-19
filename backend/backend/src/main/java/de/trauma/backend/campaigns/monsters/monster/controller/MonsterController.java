package de.trauma.backend.campaigns.monsters.monster.controller;

import de.trauma.backend.campaigns.monsters.monster.domain.Monster;
import de.trauma.backend.campaigns.monsters.monster.service.MonsterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monsters")
public class MonsterController {
    private final MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping
    public List<MonsterDTO> list() {
        return this.monsterService.findAllMonsters()
                .stream()
                .map(MonsterDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public MonsterDTO read(@PathVariable Long id) {
        return this.monsterService.findMonsterById(id)
                .map(MonsterDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public MonsterDTO create(@RequestBody Monster monster) {
        return new MonsterDTO(this.monsterService.createMonster(monster));
    }

    @PutMapping("/{id}")
    public MonsterDTO update(@PathVariable Long id, @RequestBody Monster monster) {
        return new MonsterDTO(this.monsterService.updateMonster(id, monster));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.monsterService.deleteMonster(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
