package de.trauma.backend.characterCreation.npc.repository;

import javax.persistence.*;

@Entity
@Table
public class NpcEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
