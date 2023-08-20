package de.trauma.backend.characters.ability.domain;

import de.trauma.backend.characters.ability.repository.AbilityEntity;
import de.trauma.backend.characters.character.domain.Character;
import de.trauma.backend.characters.characterclass.domain.CharacterClass;
import de.trauma.backend.characters.npc.domain.Npc;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Ability {
    private Long id;
    private String name;
    private int baseScore;
    private int racialBonus;
    private int abilityImprovement;
    private int miscBonus;
    private int modifier;
    private int setScore;
    private int otherModifier;
    private int overrideScore;
    private List<Character> characters;
    private List<Npc> npcs;
    private CharacterClass characterClass;

    public Ability(AbilityEntity ability) {
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
        this.characters = ability.getCharacters().stream().map(Character::new).toList();
        this.npcs = ability.getNpcs().stream().map(Npc::new).toList();
        this.characterClass = new CharacterClass(ability.getCharacterClass());
    }
}
