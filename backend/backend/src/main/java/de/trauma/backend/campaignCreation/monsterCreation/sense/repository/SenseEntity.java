package de.trauma.backend.campaignCreation.monsterCreation.sense.repository;

import de.trauma.backend.campaignCreation.monsterCreation.sense.domain.Sense;
import de.trauma.backend.campaignCreation.monsterCreation.monster.repository.MonsterEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class SenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "senses")
    private List<MonsterEntity> monsters;

    public SenseEntity() {
    }

    public SenseEntity(Sense sense) {
        this.id = sense.getId();
        this.name = sense.getName();
        this.description = sense.getDescription();
        this.monsters = sense.getMonsters()
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MonsterEntity> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<MonsterEntity> monsters) {
        this.monsters = monsters;
    }
}
