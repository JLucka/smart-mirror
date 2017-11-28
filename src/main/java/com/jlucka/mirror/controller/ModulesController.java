package com.jlucka.mirror.controller;

import com.jlucka.mirror.service.ModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModulesController {

    private ModulesService modulesService;

    @Autowired
    public ModulesController(ModulesService modulesService) {
        this.modulesService = modulesService;
    }

    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("modules", modulesService.getModules());
        return "main";
    }

}
