package com.jlucka.mirror.module;

import org.springframework.stereotype.Component;

@Component
public class ToDoModule implements MirrorModule {

    private boolean isVisible;
    private final String name;

    public ToDoModule() {
        this.name = "todo_module";
        this.isVisible = true;
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

    @Override
    public int order() {
        return 7;
    }
}
