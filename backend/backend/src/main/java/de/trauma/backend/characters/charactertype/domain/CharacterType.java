package de.trauma.backend.characters.charactertype.domain;

import de.trauma.backend.campaigns.plots.plot.domain.Plot;
import de.trauma.backend.characters.charactertype.repository.CharacterTypeEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterType {
    private Long id;
    private String name;
    private String description;
    private List<Plot> plots;

    public CharacterType(CharacterTypeEntity characterType) {
        this.id = characterType.getId();
        this.name = characterType.getName();
        this.description = characterType.getDescription();
        this.plots = characterType.getPlots().stream().map(Plot::new).toList();
    }
}
