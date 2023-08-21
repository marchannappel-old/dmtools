package de.trauma.backend.characters.ability.controller;

import de.trauma.backend.campaigns.monsters.monster.controller.MonsterDTO;
import de.trauma.backend.characters.ability.domain.Ability;
import de.trauma.backend.characters.character.controller.CharacterDTO;
import de.trauma.backend.characters.characterclass.controller.CharacterClassDTO;
import de.trauma.backend.characters.npc.controller.NpcDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class AbilityDTO {
    private final Long id;
    private final String name;
    private final int baseScore;
    private final int racialBonus;
    private final int abilityImprovement;
    private final int miscBonus;
    private final int modifier;
    private final int setScore;
    private final int otherModifier;
    private final int overrideScore;
    private final List<CharacterDTO> characters;
    private final List<NpcDTO> npcs;
    private final List<MonsterDTO> monsters;
    private final CharacterClassDTO characterClass;

    public AbilityDTO(Ability ability) {
        this.id = ability.getId();
        this.name = ability.getName();
        this.baseScore = ability.getBaseScore();
        this.racialBonus = ability.getRacialBonus();
        this.abilityImprovement = ability.getAbilityImprovement();
        this.miscBonus = ability.getMiscBonus();
        this.modifier = ability.getModifier();
        this.setScore = ability.getSetScore();
        this.otherModifier = ability.getOtherModifier();
        this.overrideScore = ability.getOverrideScore();
        this.characters = ability.getCharacters().stream().map(CharacterDTO::new).toList();
        this.npcs = ability.getNpcs().stream().map(NpcDTO::new).toList();
        this.monsters = ability.getMonsters().stream().map(MonsterDTO::new).toList();
        this.characterClass = new CharacterClassDTO(ability.getCharacterClass());
    }
}
