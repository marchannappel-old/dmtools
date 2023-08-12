package de.trauma.backend.campaignCreation.encounterCreation.encounter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncounterRepository extends JpaRepository<EncounterEntity, Long> {
}
