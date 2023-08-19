package de.trauma.backend.characters.defense.domain;

import de.trauma.backend.characters.defense.repository.DefenseEntity;
import de.trauma.backend.characters.race.domain.Race;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Defense {
    private Long id;
    private String name;
    private String description;
    private List<Race> races;

    public Defense(DefenseEntity defense) {
        this.id = defense.getId();
        this.name = defense.getName();
        this.description = defense.getDescription();
        this.races = defense.getRaces().stream().map(Race::new).toList();
    }
}
