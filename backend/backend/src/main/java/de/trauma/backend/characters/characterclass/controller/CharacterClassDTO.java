package de.trauma.backend.characters.characterclass.controller;

import de.trauma.backend.characters.ability.controller.AbilityDTO;
import de.trauma.backend.characters.character.controller.CharacterDTO;
import de.trauma.backend.characters.characterclass.domain.CharacterClass;
import de.trauma.backend.characters.npc.controller.NpcDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class CharacterClassDTO {
    private final Long id;
    private final String name;
    private final String pronunciation;
    private final String peculiarities;
    private final String creationRules;
    private final String hitDice;
    private final int hitPointsStart;
    private final int hitPointsEnd;
    private final AbilityDTO primaryAbility;
    private final List<CharacterDTO> characters;
    private final List<NpcDTO> npcs;

    public CharacterClassDTO(CharacterClass characterClass) {
        this.id = characterClass.getId();
        this.name = characterClass.getName();
        this.pronunciation = characterClass.getPronunciation();
        this.peculiarities = characterClass.getPeculiarities();
        this.creationRules = characterClass.getCreationRules();
        this.hitDice = characterClass.getHitDice();
        this.hitPointsStart = characterClass.getHitPointsStart();
        this.hitPointsEnd = characterClass.getHitPointsEnd();
        this.primaryAbility = new AbilityDTO(characterClass.getPrimaryAbility());
        this.characters = characterClass.getCharacters().stream().map(CharacterDTO::new).toList();
        this.npcs = characterClass.getNpcs().stream().map(NpcDTO::new).toList();
    }
}
