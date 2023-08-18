package de.trauma.backend.worlds.settings.domain;

import de.trauma.backend.worlds.settings.repository.SettingsEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Settings {
    private Long id;
    private String eraBeforeYear0;
    private String eraAfterYear0;
    private String currentDisplayDate;
    private int currentYear;
    private int currentMonth;
    private int currentDay;
    private String linkToPatreon;
    private String linkToTwitter;
    private String linkDiscord;

    public Settings(SettingsEntity settings) {
        this.id = settings;
        this.eraBeforeYear0 = settings;
        this.eraAfterYear0 = settings;
        this.currentDisplayDate = settings;
        this.currentYear = settings;
        this.currentMonth = settings;
        this.currentDay = settings;
        this.linkToPatreon = settings;
        this.linkToTwitter = settings;
        this.linkDiscord = settings;
    }
}
