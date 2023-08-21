package de.trauma.backend.characters.items.itemType.repository;

import de.trauma.backend.characters.items.item.repository.ItemEntity;
import de.trauma.backend.characters.items.itemType.domain.ItemType;
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
public class ItemTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "types")
    private List<ItemEntity> items;

    public ItemTypeEntity(ItemType itemType) {
        this.id = itemType.getId();
        this.name = itemType.getName();
        this.description = itemType.getDescription();
        this.items = itemType.getItems().stream().map(ItemEntity::new).toList();
    }
}
