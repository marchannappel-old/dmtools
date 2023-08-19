package de.trauma.backend.characters.condition.domain;

import de.trauma.backend.characters.condition.repository.ConditionEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Condition {
    private Long id;
    private String name;
    private String description;
    private List<Character> characters;

    public Condition(ConditionEntity condition) {
        this.id = condition.getId();
        this.name = condition.getName();
        this.description = condition.getDescription();
        this.characters = condition.getCharacters().stream().map(Character::new).toList();
    }
}
