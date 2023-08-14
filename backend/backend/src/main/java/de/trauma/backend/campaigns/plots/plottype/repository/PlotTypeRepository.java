package de.trauma.backend.campaigns.plots.plottype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlotTypeRepository extends JpaRepository<PlotTypeEntity, Long> {
    Optional<PlotTypeEntity> findById(Long id);
}
