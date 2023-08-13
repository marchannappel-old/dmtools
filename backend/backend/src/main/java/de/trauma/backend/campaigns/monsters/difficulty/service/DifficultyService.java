package de.trauma.backend.campaigns.monsters.difficulty.service;

import de.trauma.backend.campaigns.monsters.difficulty.domain.Difficulty;
import de.trauma.backend.campaigns.monsters.difficulty.exceptions.DifficultyNotFoundException;
import de.trauma.backend.campaigns.monsters.difficulty.repository.DifficultyEntity;
import de.trauma.backend.campaigns.monsters.difficulty.repository.DifficultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DifficultyService {
    private final DifficultyRepository difficultyRepository;

    public DifficultyService(DifficultyRepository difficultyRepository) {
        this.difficultyRepository = difficultyRepository;
    }

    public List<Difficulty> findAllDifficulties() {
        return this.difficultyRepository.findAll()
                .stream()
                .map(Difficulty::new)
                .toList();
    }

    public Optional<Difficulty> findDifficultyById(Long id) {
        return this.difficultyRepository.findById(id)
                .map(Difficulty::new);
    }

    public Difficulty createDifficulty(Difficulty difficulty) {
        return new Difficulty(this.difficultyRepository.save(new DifficultyEntity(difficulty)));
    }

    public Difficulty updateDifficulty(Long id, Difficulty difficulty) {
        Optional<Difficulty> existingDifficulty = this.difficultyRepository.findById(id)
                .map(Difficulty::new);

        if (existingDifficulty.isPresent()) {
            Difficulty updatedDifficulty = existingDifficulty.get();
            updatedDifficulty.setId(difficulty.getId());
            updatedDifficulty.setName(difficulty.getName());
            updatedDifficulty.setLevel(difficulty.getLevel());
            updatedDifficulty.setExperience(difficulty.getExperience());
            updatedDifficulty.setMonsters(difficulty.getMonsters());

            return new Difficulty(this.difficultyRepository.save(new DifficultyEntity(updatedDifficulty)));
        }
        else {
            throw new DifficultyNotFoundException("Action not found with id: " + id);
        }
    }

    public void deleteDifficulty(Long id) {
        this.difficultyRepository.deleteById(id);
    }
}
