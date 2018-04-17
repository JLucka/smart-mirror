package com.jlucka.mirror.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AirlyResponse {
    private double airQualityIndex;
    private double pm25;
    private double pm10;
    private int pollutionLevel;

    public AirlyResponse() {
    }

    public AirlyResponse(double airQualityIndex, double pm25, double pm10, int pollutionLevel) {
        this.airQualityIndex = airQualityIndex;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.pollutionLevel = pollutionLevel;
    }

    public double getAirQualityIndex() {
        return airQualityIndex;
    }

    public void setAirQualityIndex(double airQualityIndex) {
        this.airQualityIndex = airQualityIndex;
    }

    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public int getPollutionLevel() {
        return pollutionLevel;
    }

    public void setPollutionLevel(int pollutionLevel) {
        this.pollutionLevel = pollutionLevel;
    }

    @Override
    public String toString() {
        return "AirlyResponse{" +
                "airQualityIndex=" + airQualityIndex +
                ", pm25=" + pm25 +
                ", pm10=" + pm10 +
                ", pollutionLevel=" + pollutionLevel +
                '}';
    }
}
