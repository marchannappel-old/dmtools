package de.trauma.backend.characters.feature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeatureRepository extends JpaRepository<FeatureEntity, Long> {
    Optional<FeatureEntity> findById(Long id);
}
