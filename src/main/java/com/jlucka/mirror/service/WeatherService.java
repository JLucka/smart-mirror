package com.jlucka.mirror.service;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
public class WeatherService {

    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

    @Value("${openweather.key}")
    private String openWeatherKey;

    public CurrentWeather getCurrentWeather() throws APIException {
        OWM owm = new OWM(openWeatherKey);
        owm.setUnit(OWM.Unit.METRIC);
        return owm.currentWeatherByCityName("Krakow");
    }

    public String getIconTextForCode(int code) {
        Properties prop = new Properties();
        try(InputStream input = WeatherService.class.getResourceAsStream("/weather.properties")) {
            prop.load(input);
            return prop.getProperty("wi-owm-" + code);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
