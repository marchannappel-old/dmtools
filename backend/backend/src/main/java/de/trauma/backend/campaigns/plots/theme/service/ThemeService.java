package de.trauma.backend.campaigns.plots.theme.service;

import de.trauma.backend.campaigns.plots.theme.domain.Theme;
import de.trauma.backend.campaigns.plots.theme.exceptions.ThemeNotFoundException;
import de.trauma.backend.campaigns.plots.theme.repository.ThemeEntity;
import de.trauma.backend.campaigns.plots.theme.repository.ThemeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {
    private final ThemeRepository themeRepository;

    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    public List<Theme> findAllThemes() {
        return this.themeRepository.findAll()
                .stream()
                .map(Theme::new)
                .toList();
    }

    public Optional<Theme> findThemeById(Long id) {
        return this.themeRepository.findById(id)
                .map(Theme::new);
    }

    public Theme createTheme(Theme theme) {
        return new Theme(this.themeRepository.save(new ThemeEntity(theme)));
    }

    public Theme updateTheme(Long id, Theme theme) {
        Optional<Theme> existingTheme = this.themeRepository.findById(id)
                .map(Theme::new);

        if (existingTheme.isPresent()) {
            Theme updatedTheme = existingTheme.get();
            updatedTheme.setId(theme.getId());
            updatedTheme.setName(theme.getName());
            updatedTheme.setDescription(theme.getDescription());
            updatedTheme.setPlots(theme.getPlots());

            return new Theme(this.themeRepository.save(new ThemeEntity(updatedTheme)));
        }
        else {
            throw new ThemeNotFoundException("Theme could not be found with id: " + id);
        }
    }

    public void deleteTheme(Long id) {
        this.themeRepository.deleteById(id);
    }
}
