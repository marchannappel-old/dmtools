package de.trauma.backend.characters.race.repository;

import javax.persistence.*;

@Entity
@Table
public class RaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
