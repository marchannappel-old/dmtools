package de.trauma.backend.campaigns.monsterCreation.monster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonsterRepository extends JpaRepository<MonsterEntity, Long> {
    Optional<MonsterEntity> findById(Long id);
    Optional<MonsterEntity> findByName(String name);
}
