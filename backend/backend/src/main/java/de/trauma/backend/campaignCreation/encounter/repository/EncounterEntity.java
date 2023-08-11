package de.trauma.backend.campaignCreation.encounter.repository;

import javax.persistence.*;

@Entity
@Table
public class EncounterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
