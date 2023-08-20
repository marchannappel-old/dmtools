package de.trauma.backend.characters.equipment.controller;

import de.trauma.backend.characters.equipment.domain.Equipment;
import de.trauma.backend.characters.item.controller.ItemDTO;
import de.trauma.backend.characters.proficiency.controller.ProficiencyDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class EquipmentDTO {
    private final Long id;
    private final List<ItemDTO> armor;
    private final List<ItemDTO> weapons;
    private final List<ItemDTO> tools;
    private final List<ProficiencyDTO> proficiencies;

    public EquipmentDTO(Equipment equipment) {
        this.id = equipment.getId();
        this.armor = equipment.getArmor().stream().map(ItemDTO::new).toList();
        this.weapons = equipment.getWeapons().stream().map(ItemDTO::new).toList();
        this.tools = equipment.getTools().stream().map(ItemDTO::new).toList();
        this.proficiencies = equipment.getProficiencies().stream().map(ProficiencyDTO::new).toList();
    }
}
