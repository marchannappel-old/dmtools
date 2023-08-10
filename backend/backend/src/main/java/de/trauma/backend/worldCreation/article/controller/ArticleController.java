package de.trauma.backend.worldCreation.article.controller;

import de.trauma.backend.worldCreation.article.domain.Article;
import de.trauma.backend.worldCreation.article.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<ArticleDTO> list() {
        return this.articleService.findAllArticles()
                .stream()
                .map(ArticleDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ArticleDTO read(@PathVariable Long id) throws ClassNotFoundException {
        return this.articleService.findArticleById(id)
                .map(ArticleDTO::new)
                .orElseThrow(ClassNotFoundException::new);
    }

    @PostMapping
    public ArticleDTO create(@RequestBody Article article) {
        return new ArticleDTO(this.articleService.createArticle(article));
    }

    @PutMapping("/{id}")
    public ArticleDTO update(@PathVariable Long id, @RequestBody Article article) throws ClassNotFoundException {
        return new ArticleDTO(this.articleService.updateArticle(id, article));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
