package de.trauma.backend.campaigns.monsters.sense.repository;

import de.trauma.backend.campaigns.monsters.sense.domain.Sense;
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

    public SenseEntity(Sense sense) {
        this.id = sense.getId();
        this.name = sense.getName();
        this.description = sense.getDescription();
        this.monsters = sense.getMonsters()
                .stream()
                .map(MonsterEntity::new)
                .toList();
    }
}
