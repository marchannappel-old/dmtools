package de.trauma.backend.characterCreation.condition.repository;

import javax.persistence.*;

@Entity
@Table
public class ConditionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
