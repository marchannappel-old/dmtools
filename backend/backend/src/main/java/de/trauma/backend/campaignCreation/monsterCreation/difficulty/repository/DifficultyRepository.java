package de.trauma.backend.campaignCreation.monsterCreation.difficulty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DifficultyRepository extends JpaRepository<DifficultyEntity, Long> {
}
