package de.trauma.backend.campaignCreation.sessionCreation.sessionlog.repository;

import javax.persistence.*;

@Entity
@Table
public class SessionLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
