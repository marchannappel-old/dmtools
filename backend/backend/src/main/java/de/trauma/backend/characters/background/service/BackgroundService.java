package de.trauma.backend.characters.background.service;

import de.trauma.backend.characters.background.domain.Background;
import de.trauma.backend.characters.background.exceptions.BackgroundNotFoundException;
import de.trauma.backend.characters.background.repository.BackgroundEntity;
import de.trauma.backend.characters.background.repository.BackgroundRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BackgroundService {
    private final BackgroundRepository backgroundRepository;

    public BackgroundService(BackgroundRepository backgroundRepository) {
        this.backgroundRepository = backgroundRepository;
    }

    public List<Background> findAllBackgrounds() {
        return this.backgroundRepository.findAll()
                .stream()
                .map(Background::new)
                .toList();
    }

    public Optional<Background> findBackgroundById(Long id) {
        return this.backgroundRepository.findById(id)
                .map(Background::new);
    }

    public Background createBackground(Background background) {
        return new Background(this.backgroundRepository.save(new BackgroundEntity(background)));
    }

    public Background updateBackground(Long id, Background background) {
        Optional<Background> existingBackground = this.backgroundRepository.findById(id)
                .map(Background::new);

        if (existingBackground.isPresent()) {
            Background updatedBackground = existingBackground.get();
            updatedBackground.setId(background.getId());
            updatedBackground.setName(background.getName());
            updatedBackground.setFaith(background.getFaith());
            updatedBackground.setHair(background.getHair());
            updatedBackground.setSkin(background.getSkin());
            updatedBackground.setEyes(background.getEyes());
            updatedBackground.setHeight(background.getHeight());
            updatedBackground.setWeight(background.getWeight());
            updatedBackground.setAge(background.getAge());
            updatedBackground.setGender(background.getGender());
            updatedBackground.setPersonalityTraits(background.getPersonalityTraits());
            updatedBackground.setIdeals(background.getIdeals());
            updatedBackground.setBonds(background.getBonds());
            updatedBackground.setFlaws(background.getFlaws());
            updatedBackground.setOrganisations(background.getOrganisations());
            updatedBackground.setAllies(background.getAllies());
            updatedBackground.setEnemies(background.getEnemies());
            updatedBackground.setBackstory(background.getBackstory());
            updatedBackground.setLanguages(background.getLanguages());
            updatedBackground.setFeatures(background.getFeatures());
            updatedBackground.setAlignments(background.getAlignments());
            updatedBackground.setLifestyles(background.getLifestyles());
            updatedBackground.setNotes(background.getNotes());
            updatedBackground.setCharacter(background.getCharacter());
            updatedBackground.setNpc(background.getNpc());

            return new Background(this.backgroundRepository.save(new BackgroundEntity(updatedBackground)));
        }
        else {
            throw new BackgroundNotFoundException("Background could not be found with id: " + id);
        }
    }

    public void deleteBackground(Long id) {
        this.backgroundRepository.deleteById(id);
    }
}
