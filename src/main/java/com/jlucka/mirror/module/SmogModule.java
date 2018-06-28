package com.jlucka.mirror.module;

import com.jlucka.mirror.service.SmogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmogModule implements MirrorModule {

    private boolean isVisible;
    private final SmogService smogService;
    private final String name;

    @Autowired
    public SmogModule(SmogService smogService) {
        this.name = "smog_module";
        this.isVisible = true;
        this.smogService = smogService;
    }

    public int getSmogLevel() {
        return smogService.getCurrentSmogLevel().getPollutionLevel();
    }

    public double getPm25() {
        return smogService.getCurrentSmogLevel().getPm25();
    }

    public double getPm10() {
        return smogService.getCurrentSmogLevel().getPm10();
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

    @Override
    public int order() {
        return 2;
    }
}
