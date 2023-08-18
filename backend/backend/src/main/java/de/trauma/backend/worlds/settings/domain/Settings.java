package de.trauma.backend.worlds.settings.domain;

import de.trauma.backend.worlds.settings.repository.SettingsEntity;
import de.trauma.backend.worlds.world.domain.World;
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
    private boolean privacyState;
    private World world;

    public Settings(SettingsEntity settings) {
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
        this.world = new World(settings.getWorld());
    }
}
