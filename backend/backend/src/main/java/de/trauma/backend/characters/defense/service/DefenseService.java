package de.trauma.backend.characters.defense.service;

import de.trauma.backend.characters.defense.domain.Defense;
import de.trauma.backend.characters.defense.exceptions.DefenseNotFoundException;
import de.trauma.backend.characters.defense.repository.DefenseEntity;
import de.trauma.backend.characters.defense.repository.DefenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefenseService {
    private final DefenseRepository defenseRepository;

    public DefenseService(DefenseRepository defenseRepository) {
        this.defenseRepository = defenseRepository;
    }

    public List<Defense> findAllDefenses() {
        return this.defenseRepository.findAll()
                .stream()
                .map(Defense::new)
                .toList();
    }

    public Optional<Defense> findDefenseById(Long id) {
        return this.defenseRepository.findById(id)
                .map(Defense::new);
    }

    public Defense createDefense(Defense defense) {
        return new Defense(this.defenseRepository.save(new DefenseEntity(defense)));
    }

    public Defense updateDefense(Long id, Defense defense) {
        Optional<Defense> existingDefense = this.defenseRepository.findById(id)
                .map(Defense::new);

        if (existingDefense.isPresent()) {
            Defense updatedDefense = existingDefense.get();
            updatedDefense.setId(defense.getId());
            updatedDefense.setName(defense.getName());
            updatedDefense.setDescription(defense.getDescription());
            updatedDefense.setRaces(defense.getRaces());

            return new Defense(this.defenseRepository.save(new DefenseEntity(updatedDefense)));
        }
        else {
            throw new DefenseNotFoundException("Defense could not be found with id: " + id);
        }
    }

    public void deleteDefense(Long id) {
        this.defenseRepository.deleteById(id);
    }
}
