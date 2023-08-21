package de.trauma.backend.characters.items.itemType.controller;

import de.trauma.backend.characters.items.item.controller.ItemDTO;
import de.trauma.backend.characters.items.itemType.domain.ItemType;
import lombok.Getter;

import java.util.List;

@Getter
public class ItemTypeDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<ItemDTO> items;

    public ItemTypeDTO(ItemType itemType) {
        this.id = itemType.getId();
        this.name = itemType.getName();
        this.description = itemType.getDescription();
        this.items = itemType.getItems().stream().map(ItemDTO::new).toList();
    }
}
