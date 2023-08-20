package de.trauma.backend.characters.characterclass.service;

import de.trauma.backend.characters.characterclass.domain.CharacterClass;
import de.trauma.backend.characters.characterclass.exceptions.CharacterClassNotFoundException;
import de.trauma.backend.characters.characterclass.repository.CharacterClassEntity;
import de.trauma.backend.characters.characterclass.repository.CharacterClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterClassService {
    private final CharacterClassRepository characterClassRepository;

    public CharacterClassService(CharacterClassRepository characterClassRepository) {
        this.characterClassRepository = characterClassRepository;
    }

    public List<CharacterClass> findAllClasses() {
        return this.characterClassRepository.findAll()
                .stream()
                .map(CharacterClass::new)
                .toList();
    }

    public Optional<CharacterClass> findClassById(Long id) {
        return this.characterClassRepository.findById(id)
                .map(CharacterClass::new);
    }

    public CharacterClass createClass(CharacterClass characterClass) {
        return new CharacterClass(this.characterClassRepository.save(new CharacterClassEntity(characterClass)));
    }

    public CharacterClass updateClass(Long id, CharacterClass characterClass) {
        Optional<CharacterClass> existingClass = this.characterClassRepository.findById(id)
                .map(CharacterClass::new);

        if (existingClass.isPresent()) {
            CharacterClass updatedClass = existingClass.get();
            updatedClass.setId(characterClass.getId());
            updatedClass.setName(characterClass.getName());
            updatedClass.setPronunciation(characterClass.getPronunciation());
            updatedClass.setPeculiarities(characterClass.getPeculiarities());
            updatedClass.setCreationRules(characterClass.getCreationRules());
            updatedClass.setHitDice(characterClass.getHitDice());
            updatedClass.setHitPointsStart(characterClass.getHitPointsStart());
            updatedClass.setHitPointsEnd(characterClass.getHitPointsEnd());
            updatedClass.setPrimaryAbility(characterClass.getPrimaryAbility());
            updatedClass.setCharacters(characterClass.getCharacters());
            updatedClass.setNpcs(characterClass.getNpcs());

            return new CharacterClass(this.characterClassRepository.save(new CharacterClassEntity(updatedClass)));
        }
        else {
            throw new CharacterClassNotFoundException("Class could not be found with id: " + id);
        }
    }

    public void deleteClass(Long id) {
        this.characterClassRepository.deleteById(id);
    }
}
