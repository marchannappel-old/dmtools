package de.trauma.backend.characters.background.repository;

import javax.persistence.*;

@Entity
@Table
public class BackgroundEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
