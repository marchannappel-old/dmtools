package de.trauma.backend.campaigns.plots.theme.service;

import de.trauma.backend.campaigns.plots.theme.domain.Theme;
import de.trauma.backend.campaigns.plots.theme.repository.ThemeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {
    private final ThemeRepository themeRepository;

    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    public List<Theme> findAllThemes() {

    }

    public Theme findThemeById(Long id) {

    }

    public Theme createTheme(Theme theme) {

    }

    public Theme updateTheme(Long id, Theme theme) {

    }

    public void deleteTheme(Long id) {

    }
}
