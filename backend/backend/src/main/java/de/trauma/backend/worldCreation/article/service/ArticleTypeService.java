package de.trauma.backend.worldCreation.article.service;

import de.trauma.backend.worldCreation.article.domain.ArticleType;
import de.trauma.backend.worldCreation.article.exceptions.ArticleTypeNotFoundException;
import de.trauma.backend.worldCreation.article.repository.ArticleTypeEntity;
import de.trauma.backend.worldCreation.article.repository.ArticleTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleTypeService {
    private final ArticleTypeRepository articleTypeRepository;

    public ArticleTypeService(ArticleTypeRepository articleTypeRepository) {
        this.articleTypeRepository = articleTypeRepository;
    }

    public List<ArticleType> findAllArticleTypes() {
        return this.articleTypeRepository.findAll()
                .stream()
                .map(ArticleType::new)
                .toList();
    }

    public Optional<ArticleType> findArticleTypeById(Long id) {
        return this.articleTypeRepository.findById(id)
                .map(ArticleType::new);
    }

    public ArticleType createArticleType(ArticleType articleType) {
        return new ArticleType(this.articleTypeRepository.save(new ArticleTypeEntity(articleType)));
    }

    public ArticleType updateArticleType(Long id, ArticleType articleType) throws ArticleTypeNotFoundException {
        Optional<ArticleType> existingArticleType = this.articleTypeRepository.findById(id)
                .map(ArticleType::new);

        if (existingArticleType.isPresent()) {
            ArticleType existingType = existingArticleType.get();
            existingType.setName(articleType.getName());

            return new ArticleType(this.articleTypeRepository.save(new ArticleTypeEntity(existingType)));
        }
        else {
            throw new ArticleTypeNotFoundException("ArticleType not found with id: " + id);
        }
    }

    public void deleteArticleType(Long id) {
        this.articleTypeRepository.deleteById(id);
    }
}
