package de.trauma.backend.characters.characterclass.domain;

import de.trauma.backend.characters.ability.domain.Ability;
import de.trauma.backend.characters.character.domain.Character;
import de.trauma.backend.characters.characterclass.repository.CharacterClassEntity;
import de.trauma.backend.characters.npc.domain.Npc;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterClass {
    private Long id;
    private String name;
    private String pronunciation;
    private String peculiarities;
    private String creationRules;
    private String hitDice;
    private int hitPointsStart;
    private int hitPointsEnd;
    private Ability primaryAbility;
    private List<Character> characters;
    private List<Npc> npcs;

    public CharacterClass(CharacterClassEntity classEntity) {
        this.id = classEntity.getId();
        this.name = classEntity.getName();
        this.pronunciation = classEntity.getPronunciation();
        this.peculiarities = classEntity.getPeculiarities();
        this.creationRules = classEntity.getCreationRules();
        this.hitDice = classEntity.getHitDice();
        this.hitPointsStart = classEntity.getHitPointsStart();
        this.hitPointsEnd = classEntity.getHitPointsEnd();
        this.primaryAbility = new Ability(classEntity.getPrimaryAbility());
        this.characters = classEntity.getCharacters().stream().map(Character::new).toList();
        this.npcs = classEntity.getNpcs().stream().map(Npc::new).toList();
    }
}
