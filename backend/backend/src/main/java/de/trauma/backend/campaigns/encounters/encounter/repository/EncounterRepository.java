package de.trauma.backend.campaigns.encounters.encounter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EncounterRepository extends JpaRepository<EncounterEntity, Long> {
    Optional<EncounterEntity> findById(Long id);
}
