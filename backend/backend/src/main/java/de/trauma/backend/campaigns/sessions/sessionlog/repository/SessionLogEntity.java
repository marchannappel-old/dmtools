package de.trauma.backend.campaigns.sessions.sessionlog.repository;

import javax.persistence.*;

@Entity
@Table
public class SessionLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
