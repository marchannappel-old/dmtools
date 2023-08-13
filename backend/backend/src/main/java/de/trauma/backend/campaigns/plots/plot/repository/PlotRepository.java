package de.trauma.backend.campaigns.plots.plot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlotRepository extends JpaRepository<PlotEntity, Long> {
    Optional<PlotEntity> findById(Long id);
}
