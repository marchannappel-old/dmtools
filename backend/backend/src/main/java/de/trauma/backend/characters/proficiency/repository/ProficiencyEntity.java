package de.trauma.backend.characters.proficiency.repository;

import de.trauma.backend.characters.characterclass.domain.CharacterClass;
import de.trauma.backend.characters.characterclass.repository.CharacterClassEntity;
import de.trauma.backend.characters.equipment.repository.EquipmentEntity;
import de.trauma.backend.characters.proficiency.domain.Proficiency;
import de.trauma.backend.characters.skill.repository.SkillEntity;
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
public class ProficiencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String armor;

    @Column
    private String weapons;

    @Column
    private String tools;

    @Column
    private String savingThrows;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "proficiency_skill",
            joinColumns = @JoinColumn(name = "proficiency_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<SkillEntity> skills;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "proficiency_equipment",
            joinColumns = @JoinColumn(name = "proficiency_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private List<EquipmentEntity> equipments;

    @ManyToMany(mappedBy = "proficiencies")
    private List<CharacterClassEntity> classes;

    public ProficiencyEntity(Proficiency proficiency) {
        this.id = proficiency.getId();
        this.armor = proficiency.getArmor();
        this.weapons = proficiency.getWeapons();
        this.tools = proficiency.getTools();
        this.savingThrows = proficiency.getSavingThrows();
        this.skills = proficiency.getSkills().stream().map(SkillEntity::new).toList();
        this.equipments = proficiency.getEquipments().stream().map(EquipmentEntity::new).toList();
        this.classes = proficiency.getClasses().stream().map(CharacterClassEntity::new).toList();
    }
}
