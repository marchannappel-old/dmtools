package de.trauma.backend.campaigns.plot.repository;

import javax.persistence.*;

@Entity
@Table
public class PlotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
