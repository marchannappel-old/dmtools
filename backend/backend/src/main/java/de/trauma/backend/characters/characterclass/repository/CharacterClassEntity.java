package de.trauma.backend.characters.characterclass.repository;

import javax.persistence.*;

@Entity
@Table
public class CharacterClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
