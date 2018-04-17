package com.jlucka.mirror.module;

import org.springframework.stereotype.Component;

@Component
public class QuotesModule implements MirrorModule {

    private boolean isVisible;
    private final String name;

    public QuotesModule() {
        this.name = "quotes_module";
        this.isVisible = true;
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public String name() {
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

}