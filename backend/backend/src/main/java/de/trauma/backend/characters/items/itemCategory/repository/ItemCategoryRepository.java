package de.trauma.backend.characters.items.itemCategory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategoryEntity, Long> {
    Optional<ItemCategoryEntity> findById(Long id);
}
