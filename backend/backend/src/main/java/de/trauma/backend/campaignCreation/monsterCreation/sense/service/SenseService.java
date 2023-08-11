package de.trauma.backend.campaignCreation.monsterCreation.sense.service;

import de.trauma.backend.campaignCreation.monsterCreation.sense.domain.Sense;
import de.trauma.backend.campaignCreation.monsterCreation.sense.exceptions.SenseNotFoundException;
import de.trauma.backend.campaignCreation.monsterCreation.sense.repository.SenseEntity;
import de.trauma.backend.campaignCreation.monsterCreation.sense.repository.SenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SenseService {
    private final SenseRepository senseRepository;

    public SenseService(SenseRepository senseRepository) {
        this.senseRepository = senseRepository;
    }

    public List<Sense> findAllSenses() {
        return this.senseRepository.findAll()
                .stream()
                .map(Sense::new)
                .toList();
    }

    public Optional<Sense> findSenseById(Long id) {
        return this.senseRepository.findById(id)
                .map(Sense::new);
    }

    public Sense createSense(Sense sense) {
        return new Sense(this.senseRepository.save(new SenseEntity(sense)));
    }

    public Sense updateSense(Long id, Sense sense) {
        Optional<Sense> existingSense = this.senseRepository.findById(id)
                .map(Sense::new);

        if (existingSense.isPresent()) {
            Sense updatedSense = existingSense.get();
            updatedSense.setId(sense.getId());
            updatedSense.setName(sense.getName());
            updatedSense.setDescription(sense.getDescription());
            updatedSense.setMonsters(sense.getMonsters());

            return new Sense(this.senseRepository.save(new SenseEntity(updatedSense)));
        }
        else {
            throw new SenseNotFoundException("Sense not found with id: " + id);
        }
    }

    public void deleteSense(Long id) {
        this.senseRepository.deleteById(id);
    }
}
