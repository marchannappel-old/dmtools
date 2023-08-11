package de.trauma.backend.campaignCreation.plot.repository;

import javax.persistence.*;

@Entity
@Table
public class PlotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
