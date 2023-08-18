package de.trauma.backend.characters.charactertype.repository;

import de.trauma.backend.campaigns.plots.plot.repository.PlotEntity;
import de.trauma.backend.characters.charactertype.domain.CharacterType;
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
public class CharacterTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "adversaryType")
    private List<PlotEntity> plots;

    public CharacterTypeEntity(CharacterType characterType) {
        this.id = characterType.getId();
        this.name = characterType.getName();
        this.description = characterType.getDescription();
        this.plots = characterType.getPlots().stream().map(PlotEntity::new).toList();
    }
}
