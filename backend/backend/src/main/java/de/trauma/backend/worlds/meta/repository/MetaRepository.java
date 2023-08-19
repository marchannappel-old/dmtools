package de.trauma.backend.worlds.meta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetaRepository extends JpaRepository<MetaEntity, Long> {
    Optional<MetaEntity> findById(Long id);
}
