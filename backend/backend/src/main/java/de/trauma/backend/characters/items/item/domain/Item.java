package de.trauma.backend.characters.items.item.domain;

import de.trauma.backend.characters.items.item.repository.ItemEntity;
import de.trauma.backend.characters.items.itemCategory.domain.ItemCategory;
import de.trauma.backend.characters.items.itemType.domain.ItemType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Item {
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private int weight;
    private int capacity;
    private float cost;
    private boolean proficient;
    private String attackType;
    private int reach;
    private int damage;
    private String damageType;
    private String armorClass;
    private List<ItemType> itemTypes;
    private List<ItemCategory> itemCategories;

    // TODO: complete mapping of missing properties
    public Item(ItemEntity item) {
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
        this.itemTypes = item.getItemTypes().stream().map(ItemType::new).toList();
        this.itemCategories = item.getItemCategories().stream().map(ItemCategory::new).toList();
    }
}
