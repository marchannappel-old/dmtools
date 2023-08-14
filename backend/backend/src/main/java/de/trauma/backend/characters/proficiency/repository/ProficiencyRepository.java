package de.trauma.backend.characters.proficiency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProficiencyRepository extends JpaRepository<ProficiencyEntity, Long> {
}
