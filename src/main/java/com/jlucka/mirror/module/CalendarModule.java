package com.jlucka.mirror.module;

import org.springframework.stereotype.Component;

@Component
public class CalendarModule implements MirrorModule {

    private boolean isVisible;
    private final String name;

    public CalendarModule() {
        this.name = "calendar_module";
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
