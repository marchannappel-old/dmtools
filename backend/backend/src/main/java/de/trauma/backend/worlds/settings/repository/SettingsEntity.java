package de.trauma.backend.worlds.settings.repository;

import de.trauma.backend.worlds.settings.domain.Settings;
import de.trauma.backend.worlds.world.repository.WorldEntity;
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

    @Column
    private boolean privacyState;

    @OneToOne(mappedBy = "setting")
    private WorldEntity world;

    public SettingsEntity(Settings settings) {
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
        this.world = new WorldEntity(settings.getWorld());
    }
}
