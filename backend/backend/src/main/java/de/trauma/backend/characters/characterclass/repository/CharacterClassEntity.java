package de.trauma.backend.characters.characterclass.repository;

import de.trauma.backend.characters.ability.repository.AbilityEntity;
import de.trauma.backend.characters.character.repository.CharacterEntity;
import de.trauma.backend.characters.characterclass.domain.CharacterClass;
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
public class CharacterClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String pronunciation;

    @Column
    private String peculiarities;

    @Column
    private String creationRules;

    @Column
    private String hitDice;

    @Column
    private int hitPointsStart;

    @Column
    private int hitPointsEnd;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ability_id")
    private AbilityEntity primaryAbility;

    @ManyToMany(mappedBy = "classes")
    private List<CharacterEntity> characters;

    @ManyToMany(mappedBy = "classes")
    private List<NpcEntity> npcs;

    public CharacterClassEntity(CharacterClass characterClass) {
        this.id = characterClass.getId();
        this.name = characterClass.getName();
        this.pronunciation = characterClass.getPronunciation();
        this.peculiarities = characterClass.getPeculiarities();
        this.creationRules = characterClass.getCreationRules();
        this.hitDice = characterClass.getHitDice();
        this.hitPointsStart = characterClass.getHitPointsStart();
        this.hitPointsEnd = characterClass.getHitPointsEnd();
        this.primaryAbility = new AbilityEntity(characterClass.getPrimaryAbility());
        this.characters = characterClass.getCharacters().stream().map(CharacterEntity::new).toList();
        this.npcs = characterClass.getNpcs().stream().map(NpcEntity::new);
    }
}
