package de.trauma.backend.worlds.world.repository;

import de.trauma.backend.campaigns.campaign.repository.CampaignEntity;
import de.trauma.backend.worlds.articles.article.repository.ArticleEntity;
import de.trauma.backend.worlds.meta.repository.MetaEntity;
import de.trauma.backend.worlds.world.domain.World;
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
public class WorldEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String system;

    @OneToMany(mappedBy = "world")
    private List<ArticleEntity> articles;

    @ManyToMany
    @JoinTable(
            name = "world_campaign",
            joinColumns = @JoinColumn(name = "world_id"),
            inverseJoinColumns = @JoinColumn(name = "campaign_id")
    )
    private List<CampaignEntity> campaigns;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "meta_id")
    private MetaEntity meta;

    public WorldEntity(World world) {
        this.id = world.getId();
        this.name = world.getName();
        this.system = world.getSystem();
        this.articles = world.getArticles().stream().map(ArticleEntity::new).toList();
        this.campaigns = world.getCampaigns().stream().map(CampaignEntity::new).toList();
        this.meta = new MetaEntity(world.getMeta());
    }
}
