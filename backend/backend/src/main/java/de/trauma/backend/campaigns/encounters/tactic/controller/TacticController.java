package de.trauma.backend.campaigns.encounters.tactic.controller;

import de.trauma.backend.campaigns.encounters.tactic.domain.Tactic;
import de.trauma.backend.campaigns.encounters.tactic.service.TacticService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tactics")
public class TacticController {
    private final TacticService tacticService;

    public TacticController(TacticService tacticService) {
        this.tacticService = tacticService;
    }

    @GetMapping
    public List<TacticDTO> list() {
        return this.tacticService.findAllTactics()
                .stream()
                .map(TacticDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public TacticDTO read(@PathVariable Long id) {
        return this.tacticService.findTacticById(id)
                .map(TacticDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public TacticDTO create(@RequestBody Tactic tactic) {
        return new TacticDTO(this.tacticService.createTactic(tactic));
    }

    @PutMapping("/{id}")
    public TacticDTO update(@PathVariable Long id, @RequestBody Tactic tactic) {
        return new TacticDTO(this.tacticService.updateTactic(id, tactic));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.tacticService.deleteTactic(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
