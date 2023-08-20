package de.trauma.backend.characters.skill.repository;

import de.trauma.backend.characters.proficiency.repository.ProficiencyEntity;
import de.trauma.backend.characters.skill.domain.Skill;
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
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "skills")
    private List<ProficiencyEntity> proficiencies;

    public SkillEntity(Skill skill) {
        this.id = skill.getId();
        this.name = skill.getName();
        this.proficiencies = skill.getProficiencies().stream().map(ProficiencyEntity::new).toList();
    }
}
