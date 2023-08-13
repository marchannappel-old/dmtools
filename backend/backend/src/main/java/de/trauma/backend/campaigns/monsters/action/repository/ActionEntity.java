package de.trauma.backend.campaigns.monsters.action.repository;

import de.trauma.backend.campaigns.monsters.action.domain.Action;
import de.trauma.backend.campaigns.monsters.monster.repository.MonsterEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ActionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private String description;

    @Column
    private String rarity;

    @ManyToMany(mappedBy = "actions")
    private List<MonsterEntity> monsters;

    public ActionEntity() {
    }

    public ActionEntity(Action action) {
        this.id = action.getId();
        this.name = action.getName();
        this.type = action.getType();
        this.description = action.getDescription();
        this.rarity = action.getRarity();
        this.monsters = action.getMonsters()
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public List<MonsterEntity> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<MonsterEntity> monsters) {
        this.monsters = monsters;
    }
}
