package de.trauma.backend.characterCreation.character.repository;

import javax.persistence.*;

@Entity
@Table
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
