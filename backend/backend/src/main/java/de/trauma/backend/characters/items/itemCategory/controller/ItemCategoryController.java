package de.trauma.backend.characters.items.itemCategory.controller;

import de.trauma.backend.characters.items.itemCategory.domain.ItemCategory;
import de.trauma.backend.characters.items.itemCategory.service.ItemCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemcategories")
public class ItemCategoryController {
    private final ItemCategoryService itemCategoryService;

    public ItemCategoryController(ItemCategoryService itemCategoryService) {
        this.itemCategoryService = itemCategoryService;
    }

    @GetMapping
    public List<ItemCategoryDTO> list() {
        return this.itemCategoryService.findAllItemCategories()
                .stream()
                .map(ItemCategoryDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ItemCategoryDTO read(@PathVariable Long id) {
        return this.itemCategoryService.findItemCategoryById(id)
                .map(ItemCategoryDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public ItemCategoryDTO create(@RequestBody ItemCategory itemCategory) {
        return new ItemCategoryDTO(this.itemCategoryService.createItemCategory(itemCategory));
    }

    @PutMapping("/{id}")
    public ItemCategoryDTO update(@PathVariable Long id, @RequestBody ItemCategory itemCategory) {
        return new ItemCategoryDTO(this.itemCategoryService.updateItemCategory(id, itemCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.itemCategoryService.deleteItemCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
