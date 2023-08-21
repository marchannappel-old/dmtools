package de.trauma.backend.characters.alignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlignmentRepository extends JpaRepository<AlignmentEntity, Long> {
    Optional<AlignmentEntity> findById(Long id);
}
