package de.trauma.backend.campaigns.monsters.sense.domain;

import de.trauma.backend.campaigns.monsters.monster.domain.Monster;
import de.trauma.backend.campaigns.monsters.sense.repository.SenseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Sense {
    private Long id;
    private String name;
    private String description;
    private List<Monster> monsters;

    public Sense(SenseEntity sense) {
        this.id = sense.getId();
        this.name = sense.getName();
        this.description = sense.getDescription();
        this.monsters = sense.getMonsters()
                .stream()
                .map(Monster::new)
                .toList();
    }
}
