package de.trauma.backend.characters.items.itemCategory.controller;

import de.trauma.backend.characters.items.item.controller.ItemDTO;
import de.trauma.backend.characters.items.itemCategory.domain.ItemCategory;
import lombok.Getter;

import java.util.List;

@Getter
public class ItemCategoryDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<ItemDTO> items;

    public ItemCategoryDTO(ItemCategory category) {
        this.id = category.getId();
        this.name = category.getName();
        this.description = category.getDescription();
        this.items = category.getItems().stream().map(ItemDTO::new).toList();
    }
}
