package de.trauma.backend.characterCreation.languages.repository;

import javax.persistence.*;

@Entity
@Table
public class LanguageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
