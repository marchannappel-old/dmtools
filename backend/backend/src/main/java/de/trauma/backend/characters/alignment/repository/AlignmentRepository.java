package de.trauma.backend.characters.alignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlignmentRepository extends JpaRepository<AlignmentEntity, Long> {
}
