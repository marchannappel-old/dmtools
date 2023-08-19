package de.trauma.backend.characters.condition.controller;

import de.trauma.backend.characters.character.controller.CharacterDTO;
import de.trauma.backend.characters.condition.domain.Condition;
import lombok.Getter;

import java.util.List;

@Getter
public class ConditionDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<CharacterDTO> characters;

    public ConditionDTO(Condition condition) {
        this.id = condition.getId();
        this.name = condition.getName();
        this.description = condition.getDescription();
        this.characters = condition.getCharacters().stream().map(CharacterDTO::new).toList();
    }
}
