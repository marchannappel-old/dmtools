package de.trauma.backend.characterCreation.feature.repository;

import javax.persistence.*;

@Entity
@Table
public class FeatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
