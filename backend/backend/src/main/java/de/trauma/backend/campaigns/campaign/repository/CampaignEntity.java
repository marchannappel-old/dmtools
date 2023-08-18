package de.trauma.backend.campaigns.campaign.repository;

import de.trauma.backend.campaigns.campaign.domain.Campaign;
import de.trauma.backend.worlds.world.repository.WorldEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class CampaignEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String excerpt;

    @Column
    private String introduction;

    /**
     * TODO: Replace with many to many relation to Image later on
     */
    @Column
    private String cover;

    @ManyToMany(mappedBy = "campaigns")
    private List<WorldEntity> worlds;

    public CampaignEntity(Campaign campaign) {
        this.id = campaign.getId();
        this.name = campaign.getName();
        this.excerpt = campaign.getExcerpt();
        this.introduction = campaign.getIntroduction();
        this.cover = campaign.getCover();
        this.worlds = campaign.getWorlds().stream().map(WorldEntity::new).toList();
    }
}
