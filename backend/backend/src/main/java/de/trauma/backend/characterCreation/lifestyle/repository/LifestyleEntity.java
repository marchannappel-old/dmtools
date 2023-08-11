package de.trauma.backend.characterCreation.lifestyle.repository;

import javax.persistence.*;

@Entity
@Table
public class LifestyleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
