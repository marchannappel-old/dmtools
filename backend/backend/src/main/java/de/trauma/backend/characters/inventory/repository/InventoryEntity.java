package de.trauma.backend.characters.inventory.repository;

import javax.persistence.*;

@Entity
@Table
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}