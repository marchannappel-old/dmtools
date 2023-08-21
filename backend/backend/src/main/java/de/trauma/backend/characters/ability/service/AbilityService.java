package de.trauma.backend.characters.ability.service;

import de.trauma.backend.characters.ability.domain.Ability;
import de.trauma.backend.characters.ability.exceptions.AbilityNotFoundException;
import de.trauma.backend.characters.ability.repository.AbilityEntity;
import de.trauma.backend.characters.ability.repository.AbilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbilityService {
    private final AbilityRepository abilityRepository;

    public AbilityService(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }

    public List<Ability> findAllAbilities() {
        return this.abilityRepository.findAll()
                .stream()
                .map(Ability::new)
                .toList();
    }

    public Optional<Ability> findAbilityById(Long id) {
        return this.abilityRepository.findById(id)
                .map(Ability::new);
    }

    public Ability createAbility(Ability ability) {
        return new Ability(this.abilityRepository.save(new AbilityEntity(ability)));
    }

    public Ability updateAbility(Long id, Ability ability) {
        Optional<Ability> existingAbility = this.abilityRepository.findById(id)
                .map(Ability::new);

        if (existingAbility.isPresent()) {
            Ability updatedAbility = existingAbility.get();
            updatedAbility.setId(ability.getId());
            updatedAbility.setName(ability.getName());
            updatedAbility.setBaseScore(ability.getBaseScore());
            updatedAbility.setRacialBonus(ability.getRacialBonus());
            updatedAbility.setAbilityImprovement(ability.getAbilityImprovement());
            updatedAbility.setMiscBonus(ability.getMiscBonus());
            updatedAbility.setModifier(ability.getModifier());
            updatedAbility.setSetScore(ability.getSetScore());
            updatedAbility.setOtherModifier(ability.getOtherModifier());
            updatedAbility.setOverrideScore(ability.getOverrideScore());
            updatedAbility.setCharacters(ability.getCharacters());
            updatedAbility.setNpcs(ability.getNpcs());
            updatedAbility.setMonsters(ability.getMonsters());
            updatedAbility.setCharacterClass(ability.getCharacterClass());

            return new Ability(this.abilityRepository.save(new AbilityEntity(updatedAbility)));
        }
        else {
            throw new AbilityNotFoundException("Ability could not be found with id: " + id);
        }
    }

    public void deleteAbility(Long id) {
        this.abilityRepository.deleteById(id);
    }
}
