package com.jlucka.mirror.module;

import com.jlucka.mirror.model.Article;
import com.jlucka.mirror.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class NewsModule implements MirrorModule {

    private boolean isVisible;
    private final String name;
    private final NewsService newsService;

    @Autowired
    public NewsModule(NewsService newsService) {
        this.name = "news_module";
        this.isVisible = true;
        this.newsService = newsService;
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void hide() {
        this.isVisible = false;
    }

    @Override
    public void show() {
        this.isVisible = true;
    }

    public List<Article> getArticles() {
        List<Article> articles = newsService.getArticles();
        Collections.shuffle(articles);
        return articles.subList(0, 4);
    }

    @Override
    public int order() {
        return 8;
    }
}
