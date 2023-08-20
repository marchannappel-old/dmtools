package de.trauma.backend.characters.skill.controller;

import de.trauma.backend.characters.skill.domain.Skill;
import de.trauma.backend.characters.skill.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public List<SkillDTO> list() {
        return this.skillService.findAllSkills()
                .stream()
                .map(SkillDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public SkillDTO read(@PathVariable Long id) {
        return this.skillService.findSkillById(id)
                .map(SkillDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public SkillDTO create(@RequestBody Skill skill) {
        return new SkillDTO(this.skillService.createSkill(skill));
    }

    @PutMapping("/{id}")
    public SkillDTO update(@PathVariable Long id, @RequestBody Skill skill) {
        return new SkillDTO(this.skillService.updateSkill(id, skill));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.skillService.deleteSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
