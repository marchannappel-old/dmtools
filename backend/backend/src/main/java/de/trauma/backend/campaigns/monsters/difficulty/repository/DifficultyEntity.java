package de.trauma.backend.campaigns.monsters.difficulty.repository;

import de.trauma.backend.campaigns.monsters.difficulty.domain.Difficulty;
import de.trauma.backend.campaigns.monsters.monster.repository.MonsterEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
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

    public DifficultyEntity() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<MonsterEntity> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<MonsterEntity> monsters) {
        this.monsters = monsters;
    }
}
