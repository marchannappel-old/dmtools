package de.trauma.backend.campaigns.encounters.obstacle.service;

import de.trauma.backend.campaigns.encounters.obstacle.domain.Obstacle;
import de.trauma.backend.campaigns.encounters.obstacle.exceptions.ObstacleNotFoundException;
import de.trauma.backend.campaigns.encounters.obstacle.repository.ObstacleEntity;
import de.trauma.backend.campaigns.encounters.obstacle.repository.ObstacleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObstacleService {
    private final ObstacleRepository obstacleRepository;

    public ObstacleService(ObstacleRepository obstacleRepository) {
        this.obstacleRepository = obstacleRepository;
    }

    public List<Obstacle> findAllObstacles() {
        return this.obstacleRepository.findAll()
                .stream()
                .map(Obstacle::new)
                .toList();
    }

    public Optional<Obstacle> findObstacleById(Long id) {
        return this.obstacleRepository.findById(id)
                .map(Obstacle::new);
    }

    public Obstacle createObstacle(Obstacle obstacle) {
        return new Obstacle(this.obstacleRepository.save(new ObstacleEntity(obstacle)));
    }

    public Obstacle updateObstacle(Long id, Obstacle obstacle) {
        Optional<Obstacle> existingObstacle = this.obstacleRepository.findById(id)
                .map(Obstacle::new);

        if (existingObstacle.isPresent()) {
            Obstacle updatedObstacle = existingObstacle.get();
            updatedObstacle.setId(obstacle.getId());
            updatedObstacle.setName(obstacle.getName());
            updatedObstacle.setPronunciation(obstacle.getPronunciation());
            updatedObstacle.setDescription(obstacle.getDescription());
            updatedObstacle.setEncounters(obstacle.getEncounters());

            return new Obstacle(this.obstacleRepository.save(new ObstacleEntity(updatedObstacle)));
        }
        else {
            throw new ObstacleNotFoundException("Obstacle could not be found with id: " + id);
        }
    }

    public void deleteObstacle(Long id) {
        this.obstacleRepository.deleteById(id);
    }
}
