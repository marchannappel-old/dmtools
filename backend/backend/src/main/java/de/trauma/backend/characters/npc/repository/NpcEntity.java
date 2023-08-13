package de.trauma.backend.characters.npc.repository;

import javax.persistence.*;

@Entity
@Table
public class NpcEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public NpcEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
