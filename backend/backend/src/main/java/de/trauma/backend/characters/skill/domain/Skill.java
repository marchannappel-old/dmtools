package de.trauma.backend.characters.skill.domain;

import de.trauma.backend.characters.proficiency.domain.Proficiency;
import de.trauma.backend.characters.skill.repository.SkillEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Skill {
    private Long id;
    private String name;
    private List<Proficiency> proficiencies;

    public Skill(SkillEntity skill) {
        this.id = skill.getId();
        this.name = skill.getName();
        this.proficiencies = skill.getProficiencies().stream().map(Proficiency::new).toList();
    }
}
