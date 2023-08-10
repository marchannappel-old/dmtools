package de.trauma.backend.article.service;

import de.trauma.backend.article.domain.Category;
import de.trauma.backend.article.repository.CategoryEntity;
import de.trauma.backend.article.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories() {
        return this.categoryRepository.findAll()
                .stream()
                .map(Category::new)
                .toList();
    }

    public Optional<Category> findCategoryById(Long id) {
        return this.categoryRepository.findById(id)
                .map(Category::new);
    }

    public Category createCategory(Category category) {
        return new Category(this.categoryRepository.save(new CategoryEntity(category)));
    }

    public Category updateCategory(Long id, Category category) throws ClassNotFoundException {
        Optional<Category> existingCategory = this.categoryRepository.findById(id)
                .map(Category::new);

        if (existingCategory.isPresent()) {
            Category categoryUpdated = existingCategory.get();
            categoryUpdated.setName(category.getName());

            return new Category(this.categoryRepository.save(new CategoryEntity(categoryUpdated)));
        }
        else {
            throw new ClassNotFoundException("Category not found with id: " + id);
        }
    }

    public void deleteCategory(Long id) {
        this.categoryRepository.deleteById(id);
    }
}
