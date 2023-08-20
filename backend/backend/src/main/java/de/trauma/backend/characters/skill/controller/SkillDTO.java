package de.trauma.backend.characters.skill.controller;

import de.trauma.backend.characters.proficiency.controller.ProficiencyDTO;
import de.trauma.backend.characters.skill.domain.Skill;
import lombok.Getter;

import java.util.List;

@Getter
public class SkillDTO {
    private final Long id;
    private final String name;
    private final List<ProficiencyDTO> proficiencies;

    public SkillDTO(Skill skill) {
        this.id = skill.getId();
        this.name = skill.getName();
        this.proficiencies = skill.getProficiencies().stream().map(ProficiencyDTO::new).toList();
    }
}
