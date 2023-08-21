package de.trauma.backend.characters.lifestyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LifestyleRepository extends JpaRepository<LifestyleEntity, Long> {
    Optional<LifestyleEntity> findById(Long id);
}
