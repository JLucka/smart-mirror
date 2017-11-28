package com.jlucka.mirror.module;

import com.jlucka.mirror.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingModule implements MirrorModule {

    private boolean isVisible;
    private final String name;
    private UserService userService;

    @Autowired
    public GreetingModule(UserService userService) {
        this.name = "greeting_module";
        this.isVisible = true;
        this.userService = userService;
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

    public String getGreeting() {
        return "Hello" + userService.getUser();
    }
}
