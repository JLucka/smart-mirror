package com.jlucka.mirror.module;

public interface MirrorModule {
    boolean isVisible();

    String name();

    void hide();

    void show();
}
