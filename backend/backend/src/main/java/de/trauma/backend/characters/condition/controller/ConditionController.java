package de.trauma.backend.characters.condition.controller;

import de.trauma.backend.characters.condition.domain.Condition;
import de.trauma.backend.characters.condition.service.ConditionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/conditions")
public class ConditionController {
    private final ConditionService conditionService;

    public ConditionController(ConditionService conditionService) {
        this.conditionService = conditionService;
    }

    public List<ConditionDTO> list() {
        return this.conditionService.findAllConditions()
                .stream()
                .map(ConditionDTO::new)
                .toList();
    }

    public ConditionDTO read(@PathVariable Long id) {
        return this.conditionService.findConditionById(id)
                .map(ConditionDTO::new)
                .orElseThrow();
    }

    public ConditionDTO create(@RequestBody Condition condition) {
        return new ConditionDTO(this.conditionService.createCondition(condition));
    }

    public ConditionDTO update(@PathVariable Long id, @RequestBody Condition condition) {
        return new ConditionDTO(this.conditionService.updateCondition(id, condition));
    }

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.conditionService.deleteCondition(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
