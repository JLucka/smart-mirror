package com.jlucka.mirror.service;

import com.jlucka.mirror.module.MirrorModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModulesService {

    private List<MirrorModule> modules;

    @Autowired
    public ModulesService(List<MirrorModule> modules) {
        this.modules = new ArrayList<>(modules);
    }

    public List<MirrorModule> getModules() {
        return modules;
    }

    public void hideAllModules() {
        modules.forEach(MirrorModule::hide);
    }

    public void showAllModules() {
        modules.forEach(MirrorModule::show);
    }

}
