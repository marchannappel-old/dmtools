package de.trauma.backend.characters.items.itemCategory.service;

import de.trauma.backend.characters.items.itemCategory.domain.ItemCategory;
import de.trauma.backend.characters.items.itemCategory.exceptions.ItemCategoryNotFoundException;
import de.trauma.backend.characters.items.itemCategory.repository.ItemCategoryEntity;
import de.trauma.backend.characters.items.itemCategory.repository.ItemCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemCategoryService {
    private final ItemCategoryRepository itemCategoryRepository;

    public ItemCategoryService(ItemCategoryRepository itemCategoryRepository) {
        this.itemCategoryRepository = itemCategoryRepository;
    }

    public List<ItemCategory> findAllItemCategories() {
        return this.itemCategoryRepository.findAll()
                .stream()
                .map(ItemCategory::new)
                .toList();
    }

    public Optional<ItemCategory> findItemCategoryById(Long id) {
        return this.itemCategoryRepository.findById(id)
                .map(ItemCategory::new);
    }

    public ItemCategory createItemCategory(ItemCategory itemCategory) {
        return new ItemCategory(this.itemCategoryRepository.save(new ItemCategoryEntity(itemCategory)));
    }

    public ItemCategory updateItemCategory(Long id, ItemCategory itemCategory) {
        Optional<ItemCategory> existingItemCategory = this.itemCategoryRepository.findById(id)
                .map(ItemCategory::new);

        if (existingItemCategory.isPresent()) {
            ItemCategory updatedItemCategory = existingItemCategory.get();
            updatedItemCategory.setId(itemCategory.getId());
            updatedItemCategory.setName(itemCategory.getName());
            updatedItemCategory.setDescription(itemCategory.getDescription());
            updatedItemCategory.setItems(itemCategory.getItems());

            return new ItemCategory(this.itemCategoryRepository.save(new ItemCategoryEntity(updatedItemCategory)));
        }
        else {
            throw new ItemCategoryNotFoundException("Item Category could not be found with id: " + id);
        }
    }

    public void deleteItemCategory(Long id) {
        this.itemCategoryRepository.deleteById(id);
    }
}
