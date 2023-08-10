package de.trauma.backend.article.repository;

import de.trauma.backend.world.repository.WorldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    Optional<ArticleEntity> findById(Long id);
    Optional<ArticleEntity> findByName(String name);
}
