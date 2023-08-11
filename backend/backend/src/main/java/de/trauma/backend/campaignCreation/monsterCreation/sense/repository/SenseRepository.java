package de.trauma.backend.campaignCreation.monsterCreation.sense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenseRepository extends JpaRepository<SenseEntity, Long> {
}
