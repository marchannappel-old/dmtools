package de.trauma.backend.characters.condition.controller;

import de.trauma.backend.characters.condition.domain.Condition;
import de.trauma.backend.characters.condition.service.ConditionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conditions")
public class ConditionController {
    private final ConditionService conditionService;

    public ConditionController(ConditionService conditionService) {
        this.conditionService = conditionService;
    }

    @GetMapping
    public List<ConditionDTO> list() {
        return this.conditionService.findAllConditions()
                .stream()
                .map(ConditionDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ConditionDTO read(@PathVariable Long id) {
        return this.conditionService.findConditionById(id)
                .map(ConditionDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public ConditionDTO create(@RequestBody Condition condition) {
        return new ConditionDTO(this.conditionService.createCondition(condition));
    }

    @PutMapping("/{id}")
    public ConditionDTO update(@PathVariable Long id, @RequestBody Condition condition) {
        return new ConditionDTO(this.conditionService.updateCondition(id, condition));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.conditionService.deleteCondition(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
