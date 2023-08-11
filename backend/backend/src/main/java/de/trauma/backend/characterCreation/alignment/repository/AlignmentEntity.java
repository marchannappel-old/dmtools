package de.trauma.backend.characterCreation.alignment.repository;

import javax.persistence.*;

@Entity
@Table
public class AlignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
