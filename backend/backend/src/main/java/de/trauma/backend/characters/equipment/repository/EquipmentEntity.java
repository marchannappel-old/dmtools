package de.trauma.backend.characters.equipment.repository;

import javax.persistence.*;

@Entity
@Table
public class EquipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
