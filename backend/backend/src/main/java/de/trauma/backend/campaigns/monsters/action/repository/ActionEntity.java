package de.trauma.backend.campaigns.monsters.action.repository;

import de.trauma.backend.campaigns.monsters.action.domain.Action;
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
}
