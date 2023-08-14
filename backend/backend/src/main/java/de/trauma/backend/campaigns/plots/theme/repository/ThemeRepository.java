package de.trauma.backend.campaigns.plots.theme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThemeRepository extends JpaRepository<ThemeEntity, Long> {
    Optional<ThemeEntity> findById(Long id);
}
