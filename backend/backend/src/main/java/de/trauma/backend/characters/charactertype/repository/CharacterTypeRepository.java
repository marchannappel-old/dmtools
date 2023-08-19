package de.trauma.backend.characters.charactertype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterTypeRepository extends JpaRepository<CharacterTypeEntity, Long> {
    Optional<CharacterTypeEntity> findById(Long id);
}
