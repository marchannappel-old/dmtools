package de.trauma.backend.characterCreation.skill.repository;

import javax.persistence.*;

@Entity
@Table
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
