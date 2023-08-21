package de.trauma.backend.characters.items.itemType.domain;

import de.trauma.backend.characters.items.item.domain.Item;
import de.trauma.backend.characters.items.itemType.repository.ItemTypeEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemType {
    private Long id;
    private String name;
    private String description;
    private List<Item> items;

    public ItemType(ItemTypeEntity itemType) {
        this.id = itemType.getId();
        this.name = itemType.getName();
        this.description = itemType.getDescription();
        this.items = itemType.getItems().stream().map(Item::new).toList();
    }
}
