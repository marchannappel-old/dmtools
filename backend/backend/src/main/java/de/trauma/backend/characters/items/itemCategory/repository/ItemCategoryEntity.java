package de.trauma.backend.characters.items.itemCategory.repository;

import de.trauma.backend.characters.items.item.repository.ItemEntity;
import de.trauma.backend.characters.items.itemCategory.domain.ItemCategory;
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
public class ItemCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "types")
    private List<ItemEntity> items;

    public ItemCategoryEntity(ItemCategory itemCategory) {
        this.id = itemCategory.getId();
        this.name = itemCategory.getName();
        this.description = itemCategory.getDescription();
        this.items = itemCategory.getItems().stream().map(ItemEntity::new).toList();
    }
}
