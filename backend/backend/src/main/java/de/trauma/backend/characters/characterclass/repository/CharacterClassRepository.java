package de.trauma.backend.characters.characterclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterClassRepository extends JpaRepository<CharacterClassEntity, Long> {
    Optional<CharacterClassEntity> findById(Long id);
}
