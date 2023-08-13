package de.trauma.backend.worlds.articles.articletype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleTypeRepository extends JpaRepository<ArticleTypeEntity, Long> {
    Optional<ArticleTypeEntity> findById(Long id);
    Optional<ArticleTypeEntity> findByName(String name);
}
