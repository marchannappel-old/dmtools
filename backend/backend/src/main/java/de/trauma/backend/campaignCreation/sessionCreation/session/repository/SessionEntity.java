package de.trauma.backend.campaignCreation.sessionCreation.session.repository;

import javax.persistence.*;

@Entity
@Table
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
