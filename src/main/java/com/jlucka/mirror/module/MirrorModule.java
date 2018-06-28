package com.jlucka.mirror.module;

public interface MirrorModule {
    boolean isVisible();

    int order();

    String name();

    void hide();

    void show();
}
