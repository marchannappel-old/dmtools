package de.trauma.backend.characters.items.item.controller;

import de.trauma.backend.characters.items.item.domain.Item;
import de.trauma.backend.characters.items.itemCategory.controller.ItemCategoryDTO;
import de.trauma.backend.characters.items.itemType.controller.ItemTypeDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class ItemDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final int quantity;
    private final int weight;
    private final int capacity;
    private final float cost;
    private final boolean proficient;
    private final String attackType;
    private final int reach;
    private final int damage;
    private final String damageType;
    private final String armorClass;
    private final List<ItemTypeDTO> itemTypes;
    private final List<ItemCategoryDTO> itemCategories;

    // TODO: complete mapping of missing properties
    public ItemDTO(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.description = item.getDescription();
        this.quantity = item.getQuantity();
        this.weight = item.getWeight();
        this.capacity = item.getCapacity();
        this.cost = item.getCost();
        this.proficient = item.isProficient();
        this.attackType = item.getAttackType();
        this.reach = item.getReach();
        this.damage = item.getDamage();
        this.damageType = item.getDamageType();
        this.armorClass = item.getArmorClass();
        this.itemTypes = item.getItemTypes().stream().map(ItemTypeDTO::new).toList();
        this.itemCategories = item.getItemCategories().stream().map(ItemCategoryDTO::new).toList();
    }
}
