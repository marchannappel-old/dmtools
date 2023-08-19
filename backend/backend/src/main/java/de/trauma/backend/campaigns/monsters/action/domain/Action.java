package de.trauma.backend.campaigns.monsters.action.domain;

import de.trauma.backend.campaigns.monsters.monster.domain.Monster;
import de.trauma.backend.campaigns.monsters.action.repository.ActionEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Action {
    private Long id;
    private String name;
    private String type;
    private String description;
    private String rarity;
    private List<Monster> monsters;

    public Action(ActionEntity action) {
        this.id = action.getId();
        this.name = action.getName();
        this.type = action.getType();
        this.description = action.getDescription();
        this.rarity = action.getRarity();
        this.monsters = action.getMonsters()
                .stream()
                .map(Monster::new)
                .toList();
    }
}
