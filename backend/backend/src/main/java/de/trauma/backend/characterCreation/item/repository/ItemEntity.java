package de.trauma.backend.characterCreation.item.repository;

import javax.persistence.*;

@Entity
@Table
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
