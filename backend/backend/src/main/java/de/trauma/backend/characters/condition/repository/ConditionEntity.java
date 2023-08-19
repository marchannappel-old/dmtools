package de.trauma.backend.characters.condition.repository;

import de.trauma.backend.characters.character.repository.CharacterEntity;
import de.trauma.backend.characters.condition.domain.Condition;
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
public class ConditionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "conditions")
    private List<CharacterEntity> characters;

    public ConditionEntity(Condition condition) {
        this.id = condition.getId();
        this.name = condition.getName();
        this.description = condition.getDescription();
        this.characters = condition.getCharacters().stream().map(CharacterEntity::new).toList();
    }
}
