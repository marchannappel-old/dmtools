package de.trauma.backend.characters.skill.service;

import de.trauma.backend.characters.skill.domain.Skill;
import de.trauma.backend.characters.skill.exceptions.SkillNotFoundException;
import de.trauma.backend.characters.skill.repository.SkillEntity;
import de.trauma.backend.characters.skill.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> findAllSkills() {
        return this.skillRepository.findAll()
                .stream()
                .map(Skill::new)
                .toList();
    }

    public Optional<Skill> findSkillById(Long id) {
        return this.skillRepository.findById(id)
                .map(Skill::new);
    }

    public Skill createSkill(Skill skill) {
        return new Skill(this.skillRepository.save(new SkillEntity(skill)));
    }

    public Skill updateSkill(Long id, Skill skill) {
        Optional<Skill> existingSkill = this.skillRepository.findById(id)
                .map(Skill::new);

        if (existingSkill.isPresent()) {
            Skill updatedSkill = existingSkill.get();
            updatedSkill.setId(skill.getId());
            updatedSkill.setName(skill.getName());
            updatedSkill.setProficiencies(skill.getProficiencies());

            return new Skill(this.skillRepository.save(new SkillEntity(updatedSkill)));
        }
        else {
            throw new SkillNotFoundException("Skill could not be found with id: " + id);
        }
    }

    public void deleteSkill(Long id) {
        this.skillRepository.deleteById(id);
    }
}
