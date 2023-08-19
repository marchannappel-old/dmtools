package de.trauma.backend.worlds.world.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorldRepository extends JpaRepository<WorldEntity, Long> {
    Optional<WorldEntity> findById(Long id);
    Optional<WorldEntity> findByName(String name);
}
