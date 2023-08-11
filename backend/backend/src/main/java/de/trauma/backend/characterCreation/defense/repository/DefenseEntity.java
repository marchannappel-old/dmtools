package de.trauma.backend.characterCreation.defense.repository;

import javax.persistence.*;

@Entity
@Table
public class DefenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
