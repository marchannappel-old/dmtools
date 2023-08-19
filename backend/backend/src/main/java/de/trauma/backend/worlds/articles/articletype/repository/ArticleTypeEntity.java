package de.trauma.backend.worlds.articles.articletype.repository;

import de.trauma.backend.worlds.articles.articletype.domain.ArticleType;
import de.trauma.backend.worlds.articles.article.repository.ArticleEntity;
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
public class ArticleTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "types")
    private List<ArticleEntity> articles;

    // TODO: Check this mapping for errors !
    public ArticleTypeEntity(ArticleType articleType) {
        this.id = articleType.getId();
        this.name = articleType.getName();
    }
}
