package de.trauma.backend.characters.ability.repository;

import javax.persistence.*;

@Entity
@Table
public class AbilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
