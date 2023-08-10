package de.trauma.backend.worldCreation.world.repository;

import de.trauma.backend.worldCreation.article.repository.ArticleEntity;
import de.trauma.backend.worldCreation.world.domain.World;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class WorldEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String system;

    @OneToMany(mappedBy = "world")
    private List<ArticleEntity> articles;

    public WorldEntity() {
    }

    public WorldEntity(Long id, String name, String system) {
        this.id = id;
        this.name = name;
        this.system = system;
    }

    public WorldEntity(Long id, String name, String system, List<ArticleEntity> articles) {
        this.id = id;
        this.name = name;
        this.system = system;
        this.articles = articles;
    }

    public WorldEntity(World world) {
        this.id = world.getId();
        this.name = world.getName();
        this.system = world.getSystem();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public List<ArticleEntity> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleEntity> articles) {
        this.articles = articles;
    }
}
