package de.trauma.backend.characters.proficiency.domain;

import de.trauma.backend.characters.characterclass.domain.CharacterClass;
import de.trauma.backend.characters.equipment.domain.Equipment;
import de.trauma.backend.characters.proficiency.repository.ProficiencyEntity;
import de.trauma.backend.characters.skill.domain.Skill;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Proficiency {
    private Long id;
    private String armor;
    private String weapons;
    private String tools;
    private String savingThrows;
    private List<Skill> skills;
    private List<Equipment> equipments;
    private List<CharacterClass> classes;

    public Proficiency(ProficiencyEntity proficiency) {
        this.id = proficiency.getId();
        this.armor = proficiency.getArmor();
        this.weapons = proficiency.getWeapons();
        this.tools = proficiency.getTools();
        this.savingThrows = proficiency.getSavingThrows();
        this.skills = proficiency.getSkills().stream().map(Skill::new).toList();
        this.equipments = proficiency.getEquipments().stream().map(Equipment::new).toList();
        this.classes = proficiency.getClasses().stream().map(CharacterClass::new).toList();
    }
}
