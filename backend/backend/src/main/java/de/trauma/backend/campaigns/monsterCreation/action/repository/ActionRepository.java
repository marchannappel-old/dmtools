package de.trauma.backend.campaigns.monsterCreation.action.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActionRepository extends JpaRepository<ActionEntity, Long> {
    Optional<ActionEntity> findById(Long id);
}
