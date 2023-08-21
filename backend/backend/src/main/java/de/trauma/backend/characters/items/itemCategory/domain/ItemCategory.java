package de.trauma.backend.characters.items.itemCategory.domain;

import de.trauma.backend.characters.items.item.domain.Item;
import de.trauma.backend.characters.items.itemCategory.repository.ItemCategoryEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemCategory {
    private Long id;
    private String name;
    private String description;
    private List<Item> items;

    public ItemCategory(ItemCategoryEntity itemCategory) {
        this.id = itemCategory.getId();
        this.name = itemCategory.getName();
        this.description = itemCategory.getDescription();
        this.items = itemCategory.getItems().stream().map(Item::new).toList();
    }
}
