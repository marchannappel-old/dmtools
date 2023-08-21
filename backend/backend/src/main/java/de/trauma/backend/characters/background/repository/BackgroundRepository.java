package de.trauma.backend.characters.background.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BackgroundRepository extends JpaRepository<BackgroundEntity, Long> {
    Optional<BackgroundEntity> findById(Long id);
}
