package de.trauma.backend.campaignCreation.plot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotRepository extends JpaRepository<PlotEntity, Long> {
}
