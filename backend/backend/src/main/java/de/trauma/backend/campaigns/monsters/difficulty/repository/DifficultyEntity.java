package de.trauma.backend.campaigns.monsters.difficulty.repository;

import de.trauma.backend.campaigns.monsters.difficulty.domain.Difficulty;
import de.trauma.backend.campaigns.monsters.monster.repository.MonsterEntity;
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
public class DifficultyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int level;

    @Column
    private int experience;

    @ManyToMany(mappedBy = "difficulties")
    private List<MonsterEntity> monsters;

    public DifficultyEntity(Difficulty difficulty) {
        this.id = difficulty.getId();
        this.name = difficulty.getName();
        this.level = difficulty.getLevel();
        this.experience = difficulty.getExperience();
        this.monsters = difficulty.getMonsters()
                .stream()
                .map(MonsterEntity::new)
                .toList();
    }
}
