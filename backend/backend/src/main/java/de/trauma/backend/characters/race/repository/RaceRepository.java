package de.trauma.backend.characters.race.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RaceRepository extends JpaRepository<RaceEntity, Long> {
    Optional<RaceEntity> findById(Long id);
}
