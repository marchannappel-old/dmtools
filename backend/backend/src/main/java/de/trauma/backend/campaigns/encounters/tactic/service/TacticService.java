package de.trauma.backend.campaigns.encounters.tactic.service;

import de.trauma.backend.campaigns.encounters.tactic.domain.Tactic;
import de.trauma.backend.campaigns.encounters.tactic.exceptions.TacticNotFoundException;
import de.trauma.backend.campaigns.encounters.tactic.repository.TacticEntity;
import de.trauma.backend.campaigns.encounters.tactic.repository.TacticRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacticService {
    private final TacticRepository tacticRepository;

    public TacticService(TacticRepository tacticRepository) {
        this.tacticRepository = tacticRepository;
    }

    public List<Tactic> findAllTactics() {
        return this.tacticRepository.findAll()
                .stream()
                .map(Tactic::new)
                .toList();
    }

    public Optional<Tactic> findTacticById(Long id) {
        return this.tacticRepository.findById(id)
                .map(Tactic::new);
    }

    public Tactic createTactic(Tactic tactic) {
        return new Tactic(this.tacticRepository.save(new TacticEntity(tactic)));
    }

    public Tactic updateTactic(Long id, Tactic tactic) {
        Optional<Tactic> existingTactic = this.tacticRepository.findById(id)
                .map(Tactic::new);

        if (existingTactic.isPresent()) {
            Tactic updatedTactic = existingTactic.get();
            updatedTactic.setId(tactic.getId());
            updatedTactic.setName(tactic.getName());
            updatedTactic.setDescription(tactic.getDescription());
            updatedTactic.setEncounters(tactic.getEncounters());

            return new Tactic(this.tacticRepository.save(new TacticEntity(updatedTactic)));
        }
        else {
            throw new TacticNotFoundException("Could not find tactic with id: " + id);
        }
    }

    public void deleteTactic(Long id) {
        this.tacticRepository.deleteById(id);
    }
}
