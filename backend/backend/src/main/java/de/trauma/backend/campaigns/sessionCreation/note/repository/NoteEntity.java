package de.trauma.backend.campaigns.sessionCreation.note.repository;

import javax.persistence.*;

@Entity
@Table
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
