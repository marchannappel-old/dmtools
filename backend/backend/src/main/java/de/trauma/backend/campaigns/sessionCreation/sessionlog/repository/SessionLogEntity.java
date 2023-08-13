package de.trauma.backend.campaigns.sessionCreation.sessionlog.repository;

import javax.persistence.*;

@Entity
@Table
public class SessionLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
