package com.jlucka.mirror.module;

import com.jlucka.mirror.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ComplimentsModule implements MirrorModule {

    private boolean isVisible;
    private final String name;
    private UserService userService;
    private final List<String> complimentList;

    @Autowired
    public ComplimentsModule(UserService userService) {
        this.name = "compliments_module";
        this.isVisible = true;
        this.userService = userService;
        this.complimentList = Arrays.asList("you look nice today",
                "I like your style",
                "on a scale from 1 to 10, you're an 11",
                "have an awesome day",
                "wow...",
                "your hair looks great today",
                "I love your smile");
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public String getName() {
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

    public String getCompliment() {
        Collections.shuffle(complimentList);
        return "Hello " + userService.getUser() + ", " + complimentList.get(0);
    }

    @Override
    public int order() {
        return 4;
    }
}
