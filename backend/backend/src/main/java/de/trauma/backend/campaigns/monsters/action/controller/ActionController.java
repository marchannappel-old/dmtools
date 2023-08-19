package de.trauma.backend.campaigns.monsters.action.controller;

import de.trauma.backend.campaigns.monsters.action.domain.Action;
import de.trauma.backend.campaigns.monsters.action.service.ActionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actions")
public class ActionController {
    private final ActionService actionService;

    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @GetMapping
    public List<ActionDTO> list() {
        return this.actionService.findAllActions()
                .stream()
                .map(ActionDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ActionDTO read(@PathVariable Long id) {
        return this.actionService.findActionById(id)
                .map(ActionDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public ActionDTO create(@RequestBody Action action) {
        return new ActionDTO(this.actionService.createAction(action));
    }

    @PutMapping("/{id}")
    public ActionDTO update(@PathVariable Long id, @RequestBody Action action) {
        return new ActionDTO(this.actionService.updateAction(id, action));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.actionService.deleteAction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
