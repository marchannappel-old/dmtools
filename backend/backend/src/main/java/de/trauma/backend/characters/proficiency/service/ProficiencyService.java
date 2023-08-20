package de.trauma.backend.characters.proficiency.service;

import de.trauma.backend.characters.proficiency.domain.Proficiency;
import de.trauma.backend.characters.proficiency.exceptions.ProficiencyNotFoundException;
import de.trauma.backend.characters.proficiency.repository.ProficiencyEntity;
import de.trauma.backend.characters.proficiency.repository.ProficiencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProficiencyService {
    private final ProficiencyRepository proficiencyRepository;

    public ProficiencyService(ProficiencyRepository proficiencyRepository) {
        this.proficiencyRepository = proficiencyRepository;
    }

    public List<Proficiency> findAllProficiencies() {
        return this.proficiencyRepository.findAll()
                .stream()
                .map(Proficiency::new)
                .toList();
    }

    public Optional<Proficiency> findProficiencyById(Long id) {
        return this.proficiencyRepository.findById(id)
                .map(Proficiency::new);
    }

    public Proficiency createProficiency(Proficiency proficiency) {
        return new Proficiency(this.proficiencyRepository.save(new ProficiencyEntity(proficiency)));
    }

    public Proficiency updateProficiency(Long id, Proficiency proficiency) {
        Optional<Proficiency> existingProficiency = this.proficiencyRepository.findById(id)
                .map(Proficiency::new);

        if (existingProficiency.isPresent()) {
            Proficiency updatedProficiency = existingProficiency.get();
            updatedProficiency.setId(proficiency.getId());
            updatedProficiency.setArmor(proficiency.getArmor());
            updatedProficiency.setWeapons(proficiency.getWeapons());
            updatedProficiency.setTools(proficiency.getTools());
            updatedProficiency.setSavingThrows(proficiency.getSavingThrows());
            updatedProficiency.setSkills(proficiency.getSkills());
            updatedProficiency.setEquipments(proficiency.getEquipments());
            updatedProficiency.setClasses(proficiency.getClasses());

            return new Proficiency(this.proficiencyRepository.save(new ProficiencyEntity(updatedProficiency)));
        }
        else {
            throw new ProficiencyNotFoundException("Proficiency could not be found with id: " + id);
        }
    }

    public void deleteProficiency(Long id) {
        this.proficiencyRepository.deleteById(id);
    }
}
