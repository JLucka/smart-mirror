package com.jlucka.mirror.module;

import com.jlucka.mirror.service.WeatherService;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherModule implements MirrorModule {

    private boolean isVisible;
    private final String name;
    private final WeatherService weatherService;

    @Autowired
    public WeatherModule(WeatherService weatherService) {
        this.name = "weather_module";
        this.isVisible = true;
        this.weatherService = weatherService;
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

    public String getIcon() throws APIException {
        CurrentWeather weather = weatherService.getCurrentWeather();
        String prefix = "wi wi-";
        Integer code = weather.getRespCode();
        String icon = weatherService.getIconTextForCode(code);

        if (!(code > 699 && code < 800) && !(code > 899 && code < 1000)) {
            icon = "day-" + icon;
        }

        return prefix + icon;
    }

}

