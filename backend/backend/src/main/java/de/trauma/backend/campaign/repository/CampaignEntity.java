package de.trauma.backend.campaign.repository;

import javax.persistence.*;

@Entity
@Table
public class CampaignEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
