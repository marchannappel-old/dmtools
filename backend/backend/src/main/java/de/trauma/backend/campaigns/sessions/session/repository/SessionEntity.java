package de.trauma.backend.campaigns.sessions.session.repository;

import javax.persistence.*;

@Entity
@Table
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
