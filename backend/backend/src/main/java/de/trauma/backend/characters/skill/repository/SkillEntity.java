package de.trauma.backend.characters.skill.repository;

import javax.persistence.*;

@Entity
@Table
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
