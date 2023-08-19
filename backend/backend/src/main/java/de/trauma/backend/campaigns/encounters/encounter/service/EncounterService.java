package de.trauma.backend.campaigns.encounters.encounter.service;

import de.trauma.backend.campaigns.encounters.encounter.domain.Encounter;
import de.trauma.backend.campaigns.encounters.encounter.exceptions.EncounterNotFoundException;
import de.trauma.backend.campaigns.encounters.encounter.repository.EncounterEntity;
import de.trauma.backend.campaigns.encounters.encounter.repository.EncounterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncounterService {
    private final EncounterRepository encounterRepository;

    public EncounterService(EncounterRepository encounterRepository) {
        this.encounterRepository = encounterRepository;
    }

    public List<Encounter> findAllEncounters() {
        return this.encounterRepository.findAll()
                .stream()
                .map(Encounter::new)
                .toList();
    }

    public Optional<Encounter> findEncounterById(Long id) {
        return this.encounterRepository.findById(id)
                .map(Encounter::new);
    }

    public Encounter createEncounter(Encounter encounter) {
        return new Encounter(this.encounterRepository.save(new EncounterEntity(encounter)));
    }

    public Encounter updateEncounter(Long id, Encounter encounter) {
        Optional<Encounter> existingEncounter = this.encounterRepository.findById(id)
                .map(Encounter::new);

        if (existingEncounter.isPresent()) {
            Encounter updatedEncounter = existingEncounter.get();
            updatedEncounter.setId(encounter.getId());
            updatedEncounter.setSetting(encounter.getSetting());
            updatedEncounter.setDescription(encounter.getDescription());
            updatedEncounter.setObjective(encounter.getObjective());
            updatedEncounter.setAllies(encounter.getAllies());
            updatedEncounter.setObstacles(encounter.getObstacles());
            updatedEncounter.setTactics(encounter.getTactics());
            updatedEncounter.setRewards(encounter.getRewards());
            updatedEncounter.setConsequences(encounter.getConsequences());
            updatedEncounter.setMonsters(encounter.getMonsters());
            updatedEncounter.setPlots(encounter.getPlots());

            return new Encounter(this.encounterRepository.save(new EncounterEntity(updatedEncounter)));
        }
        else {
            throw new EncounterNotFoundException("Could not find Encounter with id: " + id);
        }
    }

    public void deleteEncounter(Long id) {
        this.encounterRepository.deleteById(id);
    }
}
