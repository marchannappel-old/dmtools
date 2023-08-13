package de.trauma.backend.campaigns.campaign.repository;

import javax.persistence.*;

@Entity
@Table
public class CampaignEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
