package de.trauma.backend.campaignCreation.monster.repository;

import javax.persistence.*;

@Entity
@Table
public class MonsterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
