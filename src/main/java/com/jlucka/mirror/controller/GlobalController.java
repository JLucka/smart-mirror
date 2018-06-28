package com.jlucka.mirror.controller;

import com.jlucka.mirror.service.ModulesService;
import com.jlucka.mirror.service.ReloadService;
import com.jlucka.mirror.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GlobalController {
    private ModulesService modulesService;
    private UserService userService;
    private ReloadService reloadService;

    @Autowired
    public GlobalController(ModulesService modulesService, UserService userService, ReloadService reloadService) {
        this.modulesService = modulesService;
        this.userService = userService;
        this.reloadService = reloadService;
    }

    @RequestMapping("/hide-all")
    public void hideAll() {
        modulesService.hideAllModules();
        reloadService.setReload();
    }

    @RequestMapping("/show-all")
    public void showAll() {
        modulesService.showAllModules();
        reloadService.setReload();
    }

    @RequestMapping("change-status/{module}")
    public void changeStatusForModule(@PathVariable("module") String module) {
        modulesService.changeStatusForModule(module);
        reloadService.setReload();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void addUser(@RequestParam String userName) {
        userService.setUser(userName);
        reloadService.setReload();
    }

    @RequestMapping("/reload-check")
    public boolean reloadCheck() {
        return reloadService.checkAndClear();
    }
}
