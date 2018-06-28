package com.jlucka.mirror.module;

public interface MirrorModule {
    boolean isVisible();

    int order();

    String getName();

    void hide();

    void show();
}
