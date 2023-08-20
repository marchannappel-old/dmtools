package de.trauma.backend.characters.equipment.domain;

import de.trauma.backend.characters.equipment.repository.EquipmentEntity;
import de.trauma.backend.characters.item.domain.Item;
import de.trauma.backend.characters.proficiency.domain.Proficiency;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Equipment {
    private Long id;
    private List<Item> armor;
    private List<Item> weapons;
    private List<Item> tools;
    private List<Proficiency> proficiencies;

    public Equipment(EquipmentEntity equipment) {
        this.id = equipment.getId();
        this.armor = equipment.getArmor().stream().map(Item::new).toList();
        this.weapons = equipment.getWeapons().stream().map(Item::new).toList();
        this.tools = equipment.getTools().stream().map(Item::new).toList();
        this.proficiencies = equipment.getProficiencies().stream().map(Proficiency::new).toList();
    }
}
