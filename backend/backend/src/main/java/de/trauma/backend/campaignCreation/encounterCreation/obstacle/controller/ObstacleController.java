package de.trauma.backend.campaignCreation.encounterCreation.obstacle.controller;

import de.trauma.backend.campaignCreation.encounterCreation.obstacle.domain.Obstacle;
import de.trauma.backend.campaignCreation.encounterCreation.obstacle.service.ObstacleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obstacles")
public class ObstacleController {
    private final ObstacleService obstacleService;

    public ObstacleController(ObstacleService obstacleService) {
        this.obstacleService = obstacleService;
    }

    @GetMapping
    public List<ObstacleDTO> list() {
        return this.obstacleService.findAllObstacles()
                .stream()
                .map(ObstacleDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ObstacleDTO read(@PathVariable Long id) {
        return this.obstacleService.findObstacleById(id)
                .map(ObstacleDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public ObstacleDTO create(@RequestBody Obstacle obstacle) {
        return new ObstacleDTO(this.obstacleService.createObstacle(obstacle));
    }

    @PutMapping("/{id}")
    public ObstacleDTO update(@PathVariable Long id, @RequestBody Obstacle obstacle) {
        return new ObstacleDTO(this.obstacleService.updateObstacle(id, obstacle))
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.obstacleService.deleteObstacle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
