package de.trauma.backend.worlds.settings.controller;

import de.trauma.backend.worlds.settings.domain.Settings;
import de.trauma.backend.worlds.world.controller.WorldDTO;
import lombok.Getter;

@Getter
public class SettingsDTO {
    private final Long id;
    private final String eraBeforeYear0;
    private final String eraAfterYear0;
    private final String currentDisplayDate;
    private final int currentYear;
    private final int currentMonth;
    private final int currentDay;
    private final String linkToPatreon;
    private final String linkToTwitter;
    private final String linkDiscord;
    private final boolean privacyState;
    private final WorldDTO world;

    public SettingsDTO(Settings settings) {
        this.id = settings.getId();
        this.eraBeforeYear0 = settings.getEraBeforeYear0();
        this.eraAfterYear0 = settings.getEraAfterYear0();
        this.currentDisplayDate = settings.getCurrentDisplayDate();
        this.currentYear = settings.getCurrentYear();
        this.currentMonth = settings.getCurrentMonth();
        this.currentDay = settings.getCurrentDay();
        this.linkToPatreon = settings.getLinkToPatreon();
        this.linkToTwitter = settings.getLinkToTwitter();
        this.linkDiscord = settings.getLinkDiscord();
        this.privacyState = settings.isPrivacyState();
        this.world = new WorldDTO(settings.getWorld());
    }
}
