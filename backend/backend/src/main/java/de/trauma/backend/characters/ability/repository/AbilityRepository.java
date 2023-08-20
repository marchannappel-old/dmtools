package de.trauma.backend.characters.ability.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AbilityRepository extends JpaRepository<AbilityEntity, Long> {
    Optional<AbilityEntity> findById(Long id);
}
