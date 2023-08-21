package de.trauma.backend.characters.items.itemType.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemTypeRepository extends JpaRepository<ItemTypeEntity, Long> {
    Optional<ItemTypeEntity> findById(Long id);
}
