package de.trauma.backend.worlds.articles.category.controller;

import de.trauma.backend.worlds.articles.category.domain.Category;
import de.trauma.backend.worlds.articles.category.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDTO> list() {
        return this.categoryService.findAllCategories()
                .stream()
                .map(CategoryDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public CategoryDTO read(@PathVariable Long id) {
        return this.categoryService.findCategoryById(id)
                .map(CategoryDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public CategoryDTO create(@RequestBody Category category) {
        return new CategoryDTO(this.categoryService.createCategory(category));
    }

    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable Long id, @RequestBody Category category) throws ClassNotFoundException {
        return new CategoryDTO(this.categoryService.updateCategory(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
