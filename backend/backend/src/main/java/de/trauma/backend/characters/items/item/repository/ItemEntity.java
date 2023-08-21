package de.trauma.backend.characters.items.item.repository;

import de.trauma.backend.campaigns.encounters.encounter.repository.EncounterEntity;
import de.trauma.backend.campaigns.monsters.monster.repository.MonsterEntity;
import de.trauma.backend.characters.equipment.repository.EquipmentEntity;
import de.trauma.backend.characters.inventory.repository.InventoryEntity;
import de.trauma.backend.characters.items.item.domain.Item;
import de.trauma.backend.characters.items.itemCategory.repository.ItemCategoryEntity;
import de.trauma.backend.characters.items.itemType.repository.ItemTypeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int quantity;

    @Column
    private int weight;

    @Column
    private int capacity;

    @Column
    private float cost;

    @Column
    private boolean proficient;

    @Column
    private String attackType;

    @Column
    private int reach;

    @Column
    private int damage;

    @Column
    private String damageType;

    @Column
    private String armorClass;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "item_itemtype",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "itemtype_id")
    )
    private List<ItemTypeEntity> itemTypes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "item_itemcategory",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "itemcategory_id")
    )
    private List<ItemCategoryEntity> itemCategories;

    @ManyToMany(mappedBy = "armor")
    private List<EquipmentEntity> armorEquipments;

    @ManyToMany(mappedBy = "weapons")
    private List<EquipmentEntity> weaponEquipments;

    @ManyToMany(mappedBy = "tools")
    private List<EquipmentEntity> toolEquipments;

    @ManyToMany(mappedBy = "rewards")
    private List<EncounterEntity> encounters;

    @ManyToMany(mappedBy = "loot")
    private List<MonsterEntity> monsters;

    @ManyToMany(mappedBy = "equipment")
    private List<InventoryEntity> characterEquipment;

    @ManyToMany(mappedBy = "backpack")
    private List<InventoryEntity> characterBackpacks;

    @ManyToMany(mappedBy = "chest")
    private List<InventoryEntity> characterChest;

    @ManyToMany(mappedBy = "attunement")
    private List<InventoryEntity> characterAttunement;

    @ManyToMany(mappedBy = "otherPossessions")
    private List<InventoryEntity> characterPossessions;

    // TODO: complete mapping here
    public ItemEntity(Item item) {
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
        this.itemTypes = item.getItemTypes().stream().map(ItemTypeEntity::new).toList();
        this.itemCategories = item.getItemCategories().stream().map(ItemCategoryEntity::new).toList();
    }
}
