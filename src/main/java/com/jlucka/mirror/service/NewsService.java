package com.jlucka.mirror.service;

import com.jlucka.mirror.model.Article;
import com.jlucka.mirror.model.NewsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class NewsService {
    private static final Logger log = LoggerFactory.getLogger(SmogService.class);

    @Value("${news.url}")
    private String newsUrl;

    public List<Article> getArticles() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<NewsResponse> response = restTemplate.getForEntity(newsUrl,  NewsResponse.class);
            return response.getBody().articles;
        } catch (RestClientException e) {
            log.warn("Problem getting news data from API");
            return Collections.emptyList();
        }
    }
}
