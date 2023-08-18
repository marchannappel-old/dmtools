package de.trauma.backend.characters.charactertype.service;

import de.trauma.backend.characters.charactertype.domain.CharacterType;
import de.trauma.backend.characters.charactertype.exception.CharacterTypeNotFoundException;
import de.trauma.backend.characters.charactertype.repository.CharacterTypeEntity;
import de.trauma.backend.characters.charactertype.repository.CharacterTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterTypeService {
    private final CharacterTypeRepository characterTypeRepository;

    public CharacterTypeService(CharacterTypeRepository characterTypeRepository) {
        this.characterTypeRepository = characterTypeRepository;
    }

    public List<CharacterType> findAllCharacterTypes() {
        return this.characterTypeRepository.findAll()
                .stream()
                .map(CharacterType::new)
                .toList();
    }

    public Optional<CharacterType> findCharacterTypeById(Long id) {
        return this.characterTypeRepository.findById(id)
                .map(CharacterType::new);
    }

    public CharacterType createCharacterType(CharacterType characterType) {
        return new CharacterType(this.characterTypeRepository.save(new CharacterTypeEntity(characterType)));
    }

    public CharacterType updateCharacterType(Long id, CharacterType characterType) {
        Optional<CharacterType> existingCharacterType = this.characterTypeRepository.findById(id)
                .map(CharacterType::new);

        if (existingCharacterType.isPresent()) {
            CharacterType updatedCharacterType = existingCharacterType.get();
            updatedCharacterType.setId(characterType.getId());
            updatedCharacterType.setName(characterType.getName());
            updatedCharacterType.setDescription(characterType.getDescription());
            updatedCharacterType.setPlots(characterType.getPlots());

            return new CharacterType(this.characterTypeRepository.save(new CharacterTypeEntity(updatedCharacterType)));
        }
        else {
            throw new CharacterTypeNotFoundException("Character Type could not be found with id: " + id);
        }
    }

    public void deleteCharacterType(Long id) {
        this.characterTypeRepository.deleteById(id);
    }
}
