package de.trauma.backend.characters.proficiency.repository;

import javax.persistence.*;

@Entity
@Table
public class ProficiencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
