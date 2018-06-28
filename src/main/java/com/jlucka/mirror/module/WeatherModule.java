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
        Integer code = weather.getWeatherList().get(0).getConditionId();
        String icon = weatherService.getIconTextForCode(code);

        return prefix + icon;
    }

    @Override
    public int order() {
        return 10;
    }
}

