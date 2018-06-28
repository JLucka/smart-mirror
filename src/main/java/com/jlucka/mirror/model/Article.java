package com.jlucka.mirror.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {
    public String title;

    public String getTitle() {
        return title;
    }
}