package de.trauma.backend.worlds.articles.article.domain;

import de.trauma.backend.worlds.articles.article.repository.ArticleEntity;
import de.trauma.backend.worlds.articles.articletype.domain.ArticleType;
import de.trauma.backend.worlds.articles.category.domain.Category;
import de.trauma.backend.worlds.world.domain.World;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Article {
    private Long id;
    private String title;
    private String pronunciation;
    private String content;
    private String image;
    private World world;
    private ArticleType type;
    private List<Category> categories;

    public Article(ArticleEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.pronunciation = entity.getPronunciation();
        this.content = entity.getContent();
        this.image = entity.getImage();
        this.world = new World(entity.getWorld());
        this.type = new ArticleType(entity.getTypes().get(1));
        this.categories = entity.getCategories().stream().map(Category::new).toList();
    }
}
