package de.trauma.backend.characters.defense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DefenseRepository extends JpaRepository<DefenseEntity, Long> {
    Optional<DefenseEntity> findById(Long id);
}
