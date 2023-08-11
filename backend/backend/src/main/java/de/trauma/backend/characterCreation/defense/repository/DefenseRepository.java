package de.trauma.backend.characterCreation.defense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefenseRepository extends JpaRepository<DefenseEntity, Long> {
}
