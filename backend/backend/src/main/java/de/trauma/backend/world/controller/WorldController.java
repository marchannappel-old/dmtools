package de.trauma.backend.world.controller;

import de.trauma.backend.world.domain.World;
import de.trauma.backend.world.service.WorldService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/world")
public class WorldController {
    private final WorldService worldService;

    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

    @GetMapping
    public List<WorldDTO> list() {
        return this.worldService.findAllWorlds()
                .stream()
                .map(WorldDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public WorldDTO read(@PathVariable Long id) throws ClassNotFoundException {
        return this.worldService.findWorldById(id)
                .map(WorldDTO::new)
                .orElseThrow(ClassNotFoundException::new);
    }

    @PostMapping
    public WorldDTO create(@RequestBody World world) {
        return new WorldDTO(this.worldService.createWorld(world));
    }

    @PutMapping("/{id}")
    public WorldDTO update(@PathVariable Long id, @RequestBody World world) throws ClassNotFoundException {
        return new WorldDTO(this.worldService.updateWorld(id, world));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.worldService.deleteWorld(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
