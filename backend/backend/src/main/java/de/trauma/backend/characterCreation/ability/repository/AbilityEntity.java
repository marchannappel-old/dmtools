package de.trauma.backend.characterCreation.ability.repository;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;

@Entity
@Table
public class AbilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
