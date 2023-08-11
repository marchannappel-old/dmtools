package de.trauma.backend.characterCreation.proficiency.repository;

import javax.persistence.*;

@Entity
@Table
public class ProficiencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
