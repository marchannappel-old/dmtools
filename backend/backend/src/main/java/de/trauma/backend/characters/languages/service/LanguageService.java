package de.trauma.backend.characters.languages.service;

import de.trauma.backend.characters.languages.domain.Language;
import de.trauma.backend.characters.languages.exceptions.LanguageNotFoundException;
import de.trauma.backend.characters.languages.repository.LanguageEntity;
import de.trauma.backend.characters.languages.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> findAllLanguages() {
        return this.languageRepository.findAll()
                .stream()
                .map(Language::new)
                .toList();
    }

    public Optional<Language> findLanguageById(Long id) {
        return this.languageRepository.findById(id)
                .map(Language::new);
    }

    public Language createLanguage(Language language) {
        return new Language(this.languageRepository.save(new LanguageEntity(language)));
    }

    public Language updateLanguage(Long id, Language language) {
        Optional<Language> existingLanguage = this.languageRepository.findById(id)
                .map(Language::new);

        if (existingLanguage.isPresent()) {
            Language updatedLanguage = existingLanguage.get();
            updatedLanguage.setId(language.getId());
            updatedLanguage.setName(language.getName());
            updatedLanguage.setDescription(language.getDescription());
            updatedLanguage.setRarity(language.getRarity());
            updatedLanguage.setMonsters(language.getMonsters());
            updatedLanguage.setBackgrounds(language.getBackgrounds());

            return new Language(this.languageRepository.save(new LanguageEntity(updatedLanguage)));
        }
        else {
            throw new LanguageNotFoundException("Language could not be found with id: " + id);
        }
    }

    public void deleteLanguage(Long id) {
        this.languageRepository.deleteById(id);
    }
}
