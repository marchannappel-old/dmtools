package de.trauma.backend.campaigns.encounters.tactic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TacticRepository extends JpaRepository<TacticEntity, Long> {
    Optional<TacticEntity> findById(Long id);
}
