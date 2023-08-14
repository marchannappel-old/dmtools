package de.trauma.backend.characters.lifestyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LifestyleRepository extends JpaRepository<LifestyleEntity, Long> {
}
