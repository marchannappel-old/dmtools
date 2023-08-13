package de.trauma.backend.campaigns.encounters.consequence.service;

import de.trauma.backend.campaigns.encounters.consequence.domain.Consequence;
import de.trauma.backend.campaigns.encounters.consequence.exceptions.ConsequenceNotFoundException;
import de.trauma.backend.campaigns.encounters.consequence.repository.ConsequenceEntity;
import de.trauma.backend.campaigns.encounters.consequence.repository.ConsequenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsequenceService {
    private final ConsequenceRepository consequenceRepository;

    public ConsequenceService(ConsequenceRepository consequenceRepository) {
        this.consequenceRepository = consequenceRepository;
    }

    public List<Consequence> findAllConsequences() {
        return this.consequenceRepository.findAll()
                .stream()
                .map(Consequence::new)
                .toList();
    }

    public Optional<Consequence> findConsequenceById(Long id) {
        return this.consequenceRepository.findById(id)
                .map(Consequence::new);
    }

    public Consequence createConsequence(Consequence consequence) {
        return new Consequence(this.consequenceRepository.save(new ConsequenceEntity(consequence)));
    }

    public Consequence updateConsequence(Long id, Consequence consequence) {
        Optional<Consequence> existingConsequence = this.consequenceRepository.findById(id)
                .map(Consequence::new);

        if (existingConsequence.isPresent()) {
            Consequence updatedConsequence = existingConsequence.get();
            updatedConsequence.setId(consequence.getId());
            updatedConsequence.setName(consequence.getName());
            updatedConsequence.setDescription(consequence.getDescription());
            updatedConsequence.setEncounters(consequence.getEncounters());

            return new Consequence(this.consequenceRepository.save(new ConsequenceEntity(updatedConsequence)));
        }
        else {
            throw new ConsequenceNotFoundException("Consequence could not be found with id: " + id);
        }
    }

    public void deleteConsequence(Long id) {
        this.consequenceRepository.deleteById(id);
    }
}
