package de.trauma.backend.characters.alignment.repository;

import de.trauma.backend.campaigns.monsters.monster.repository.MonsterEntity;
import de.trauma.backend.characters.alignment.domain.Alignment;
import de.trauma.backend.characters.background.repository.BackgroundEntity;
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
public class AlignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "alignments")
    private List<BackgroundEntity> backgrounds;

    @ManyToMany(mappedBy = "alignments")
    private List<MonsterEntity> monsters;

    public AlignmentEntity(Alignment alignment) {
        this.id = alignment.getId();
        this.name = alignment.getName();
        this.description = alignment.getDescription();
        this.backgrounds = alignment.getBackgrounds().stream().map(BackgroundEntity::new).toList();
        this.monsters = alignment.getMonsters().stream().map(MonsterEntity::new).toList();
    }
}
