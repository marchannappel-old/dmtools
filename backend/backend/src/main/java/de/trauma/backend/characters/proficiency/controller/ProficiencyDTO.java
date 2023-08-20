package de.trauma.backend.characters.proficiency.controller;

import de.trauma.backend.characters.characterclass.controller.CharacterClassDTO;
import de.trauma.backend.characters.equipment.controller.EquipmentDTO;
import de.trauma.backend.characters.proficiency.domain.Proficiency;
import de.trauma.backend.characters.skill.controller.SkillDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class ProficiencyDTO {
    private final Long id;
    private final String armor;
    private final String weapons;
    private final String tools;
    private final String savingThrows;
    private final List<SkillDTO> skills;
    private final List<EquipmentDTO> equipments;
    private final List<CharacterClassDTO> classes;

    public ProficiencyDTO(Proficiency proficiency) {
        this.id = proficiency.getId();
        this.armor = proficiency.getArmor();
        this.weapons = proficiency.getWeapons();
        this.tools = proficiency.getTools();
        this.savingThrows = proficiency.getSavingThrows();
        this.skills = proficiency.getSkills().stream().map(SkillDTO::new).toList();
        this.equipments = proficiency.getEquipments().stream().map(EquipmentDTO::new).toList();
        this.classes = proficiency.getClasses().stream().map(CharacterClassDTO::new).toList();
    }
}
