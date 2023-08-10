package de.trauma.backend.article.service;

import de.trauma.backend.article.domain.Article;
import de.trauma.backend.article.repository.ArticleEntity;
import de.trauma.backend.article.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> findAllArticles() {
        return this.articleRepository.findAll()
                .stream()
                .map(Article::new)
                .toList();
    }

    public Optional<Article> findArticleById(Long id) {
        return this.articleRepository.findById(id)
                .map(Article::new);
    }

    public Article createArticle(Article article) {
        return new Article(this.articleRepository.save(new ArticleEntity(article)));
    }

    public Article updateArticle(Long id, Article article) throws ClassNotFoundException {
        Optional<Article> existingArticle = this.articleRepository.findById(id)
                .map(Article::new);

        if (existingArticle.isPresent()) {
            Article updatedArticle = existingArticle.get();
            updatedArticle.setId(article.getId());
            updatedArticle.setTitle(article.getTitle());
            updatedArticle.setPronunciation(article.getPronunciation());
            updatedArticle.setContent(article.getContent());
            updatedArticle.setImage(article.getImage());
            updatedArticle.setType(article.getType());
            updatedArticle.setCategories(article.getCategories());

            return new Article(this.articleRepository.save(new ArticleEntity(updatedArticle)));
        }
        else {
            throw new ClassNotFoundException("Article not found with id: " + id);
        }
    }

    public void deleteArticle(Long id) {
        this.articleRepository.deleteById(id);
    }
}
