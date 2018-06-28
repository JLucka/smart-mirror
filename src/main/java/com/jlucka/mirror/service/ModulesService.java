package com.jlucka.mirror.service;

import com.jlucka.mirror.module.MirrorModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ModulesService {

    private List<MirrorModule> modules;

    @Autowired
    public ModulesService(List<MirrorModule> modules) {
        this.modules = new ArrayList<>(modules);
        this.modules.sort(Comparator.comparing(MirrorModule::order));
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

    public void changeStatusForModule(String module) {
        Optional<MirrorModule> mirrorModule = modules.stream()
                .filter(it -> it.getName().split("_")[0].equals(module)).findFirst();
        if(mirrorModule.isPresent()) {
            if (mirrorModule.get().isVisible()) {
                mirrorModule.get().hide();
            } else {
                mirrorModule.get().show();
            }
        }
    }

}
