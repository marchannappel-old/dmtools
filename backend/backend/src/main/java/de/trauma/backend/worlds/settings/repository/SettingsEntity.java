package de.trauma.backend.worlds.settings.repository;

import de.trauma.backend.worlds.settings.domain.Settings;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class SettingsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String eraBeforeYear0;

    @Column
    private String eraAfterYear0;

    @Column
    private String currentDisplayDate;

    @Column
    private int currentYear;

    @Column
    private int currentMonth;

    @Column
    private int currentDay;

    @Column
    private String linkToPatreon;

    @Column
    private String linkToTwitter;

    @Column
    private String linkDiscord;

    public SettingsEntity(Settings settings) {
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
