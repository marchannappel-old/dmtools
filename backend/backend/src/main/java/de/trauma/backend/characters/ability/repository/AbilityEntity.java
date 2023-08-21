package de.trauma.backend.characters.ability.repository;

import de.trauma.backend.campaigns.monsters.monster.repository.MonsterEntity;
import de.trauma.backend.characters.ability.domain.Ability;
import de.trauma.backend.characters.character.repository.CharacterEntity;
import de.trauma.backend.characters.characterclass.repository.CharacterClassEntity;
import de.trauma.backend.characters.npc.repository.NpcEntity;
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
public class AbilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int baseScore;

    @Column
    private int racialBonus;

    @Column
    private int abilityImprovement;

    @Column
    private int miscBonus;

    @Column
    private int modifier;

    @Column
    private int setScore;

    @Column
    private int otherModifier;

    @Column
    private int overrideScore;

    @ManyToMany(mappedBy = "abilities")
    private List<CharacterEntity> characters;

    @ManyToMany(mappedBy = "abilities")
    private List<NpcEntity> npcs;

    @ManyToMany(mappedBy = "abilities")
    private List<MonsterEntity> monsters;

    @OneToOne(mappedBy = "primaryAbility")
    private CharacterClassEntity characterClass;

    public AbilityEntity(Ability ability) {
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
        this.characters = ability.getCharacters().stream().map(CharacterEntity::new).toList();
        this.npcs = ability.getNpcs().stream().map(NpcEntity::new);
        this.monsters = ability.getMonsters().stream().map(MonsterEntity::new).toList();
        this.characterClass = new CharacterClassEntity(ability.getCharacterClass());
    }
}
