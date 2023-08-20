package de.trauma.backend.characters.equipment.repository;

import de.trauma.backend.characters.equipment.domain.Equipment;
import de.trauma.backend.characters.item.repository.ItemEntity;
import de.trauma.backend.characters.proficiency.repository.ProficiencyEntity;
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
public class EquipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "equipment_armor",
            joinColumns = @JoinColumn(name = "equipment_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemEntity> armor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "equipment_weapons",
            joinColumns = @JoinColumn(name = "equipment_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemEntity> weapons;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "equipment_tools",
            joinColumns = @JoinColumn(name = "equipment_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemEntity> tools;

    @ManyToMany(mappedBy = "equipments")
    private List<ProficiencyEntity> proficiencies;

    public EquipmentEntity(Equipment equipment) {
        this.id = equipment.getId();
        this.armor = equipment.getArmor().stream().map(ItemEntity::new).toList();
        this.weapons = equipment.getWeapons().stream().map(ItemEntity::new).toList();
        this.tools = equipment.getTools().stream().map(ItemEntity::new).toList();
        this.proficiencies = equipment.getProficiencies().stream().map(ProficiencyEntity::new).toList();
    }
}
