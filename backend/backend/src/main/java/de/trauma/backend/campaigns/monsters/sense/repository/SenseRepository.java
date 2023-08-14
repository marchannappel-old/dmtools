package de.trauma.backend.campaigns.monsters.sense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SenseRepository extends JpaRepository<SenseEntity, Long> {
    Optional<SenseEntity> findById(Long id);
    Optional<SenseEntity> findByName(String name);
}
