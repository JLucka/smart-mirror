package com.jlucka.mirror.controller;

import com.jlucka.mirror.service.ModulesService;
import com.jlucka.mirror.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;

@RestController
public class GlobalController {
    private ModulesService modulesService;
    private UserService userService;

    @Autowired
    public GlobalController(ModulesService modulesService, UserService userService) {
        this.modulesService = modulesService;
        this.userService = userService;
    }

    @RequestMapping("/hide-all")
    public void hideAll() {
        modulesService.hideAllModules();
    }

    @RequestMapping("/show-all")
    public void showAll() {
        modulesService.showAllModules();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void addUser(@RequestParam String userName) {
        userService.setUser(userName);
    }

}
