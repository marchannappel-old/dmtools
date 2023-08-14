package de.trauma.backend.campaigns.encounters.consequence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsequenceRepository extends JpaRepository<ConsequenceEntity, Long> {
    Optional<ConsequenceEntity> findById(Long id);
}
