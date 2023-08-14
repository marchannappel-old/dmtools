package de.trauma.backend.campaigns.monsters.monster.service;

import de.trauma.backend.campaigns.monsters.monster.domain.Monster;
import de.trauma.backend.campaigns.monsters.monster.exceptions.MonsterNotFoundException;
import de.trauma.backend.campaigns.monsters.monster.repository.MonsterEntity;
import de.trauma.backend.campaigns.monsters.monster.repository.MonsterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonsterService {
    private final MonsterRepository monsterRepository;

    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    public List<Monster> findAllMonsters() {
        return this.monsterRepository.findAll()
                .stream()
                .map(Monster::new)
                .toList();
    }

    public Optional<Monster> findMonsterById(Long id) {
        return this.monsterRepository.findById(id)
                .map(Monster::new);
    }

    public Monster createMonster(Monster monster) {
        return new Monster(this.monsterRepository.save(new MonsterEntity(monster)));
    }

    public Monster updateMonster(Long id, Monster monster) {
        Optional<Monster> existingMonster = this.monsterRepository.findById(id)
                .map(Monster::new);

        if (existingMonster.isPresent()) {
            Monster updatedMonster = existingMonster.get();
            updatedMonster.setId(monster.getId());
            updatedMonster.setName(monster.getName());
            updatedMonster.setType(monster.getType());
            updatedMonster.setSubtype(monster.getSubtype());
            updatedMonster.setSize(monster.getSize());
            updatedMonster.setEnvironment(monster.getEnvironment());
            updatedMonster.setDescription(monster.getDescription());
            updatedMonster.setArmorClass(monster.getArmorClass());
            updatedMonster.setHitPoints(monster.getHitPoints());
            updatedMonster.setCurrentHitPoints(monster.getCurrentHitPoints());
            updatedMonster.setMovementRatePrimary(monster.getMovementRatePrimary());
            updatedMonster.setMovementRateSecondary(monster.getMovementRateSecondary());
            updatedMonster.setLair(monster.getLair());
            updatedMonster.setResistance(monster.getResistance());
            updatedMonster.setDamageImmunity(monster.getDamageImmunity());
            updatedMonster.setConditionImmunity(monster.getConditionImmunity());
            updatedMonster.setVulnerability(monster.getVulnerability());
            updatedMonster.setAlignments(monster.getAlignments());
            updatedMonster.setAbilities(monster.getAbilities());
            updatedMonster.setSenses(monster.getSenses());
            updatedMonster.setLanguages(monster.getLanguages());
            updatedMonster.setFeatures(monster.getFeatures());
            updatedMonster.setLoot(monster.getLoot());
            updatedMonster.setDifficulties(monster.getDifficulties());
            updatedMonster.setActions(monster.getActions());
            updatedMonster.setEncounters(monster.getEncounters());

            return new Monster(this.monsterRepository.save(new MonsterEntity(updatedMonster)));
        }
        else {
            throw new MonsterNotFoundException("Monster not found with id: " + id);
        }
    }

    public void deleteMonster(Long id) {
        this.monsterRepository.deleteById(id);
    }
}
