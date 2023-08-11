package de.trauma.backend.campaignCreation.sessionCreation.note.repository;

import javax.persistence.*;

@Entity
@Table
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
