package de.trauma.backend.worlds.settings.service;

import de.trauma.backend.worlds.settings.domain.Settings;
import de.trauma.backend.worlds.settings.exceptions.SettingsNotFoundException;
import de.trauma.backend.worlds.settings.repository.SettingsEntity;
import de.trauma.backend.worlds.settings.repository.SettingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettingsService {
    private final SettingsRepository settingsRepository;

    public SettingsService(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    public List<Settings> findAllSettings() {
        return this.settingsRepository.findAll()
                .stream()
                .map(Settings::new)
                .toList();
    }

    public Optional<Settings> findSettingById(Long id) {
        return this.settingsRepository.findById(id)
                .map(Settings::new);
    }

    public Settings createSettings(Settings settings) {
        return new Settings(this.settingsRepository.save(new SettingsEntity(settings)));
    }

    public Settings updateSettings(Long id, Settings settings) {
        Optional<Settings> existingSettings = this.settingsRepository.findById(id)
                .map(Settings::new);

        if (existingSettings.isPresent()) {
            Settings updatedSettings = existingSettings.get();
            updatedSettings.setId(settings.getId());
            updatedSettings.setEraBeforeYear0(settings.getEraBeforeYear0());
            updatedSettings.setEraAfterYear0(settings.getEraAfterYear0());
            updatedSettings.setCurrentDisplayDate(settings.getCurrentDisplayDate());
            updatedSettings.setCurrentYear(settings.getCurrentYear());
            updatedSettings.setCurrentMonth(settings.getCurrentMonth());
            updatedSettings.setCurrentDay(settings.getCurrentDay());
            updatedSettings.setLinkToPatreon(settings.getLinkToPatreon());
            updatedSettings.setLinkToTwitter(settings.getLinkToTwitter());
            updatedSettings.setLinkDiscord(settings.getLinkDiscord());
            updatedSettings.setPrivacyState(settings.isPrivacyState());
            updatedSettings.setWorld(settings.getWorld());

            return new Settings(this.settingsRepository.save(new SettingsEntity(updatedSettings)));
        }
        else {
            throw new SettingsNotFoundException("World settings could not be found with id: " + id);
        }
    }

    public void deleteSettings(Long id) {
        this.settingsRepository.deleteById(id);
    }
}
