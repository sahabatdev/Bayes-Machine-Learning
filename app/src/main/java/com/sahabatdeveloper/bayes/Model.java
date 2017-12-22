package com.sahabatdeveloper.bayes;

/**
 * Created by Sahabat Developer on 21/09/2017.
 */

public class Model {
    String sky;
    String airTemp;
    String Humidity;
    String wind;
    String water;
    String forecast;
    String isEnjoySport;

    public Model(String sky, String airTemp, String humidity, String wind, String water, String forecast, String isEnjoySport) {
        this.sky = sky;
        this.airTemp = airTemp;
        Humidity = humidity;
        this.wind = wind;
        this.water = water;
        this.forecast = forecast;
        this.isEnjoySport = isEnjoySport;
    }

    public String getSky() {
        return sky;
    }

    public void setSky(String sky) {
        this.sky = sky;
    }

    public String getAirTemp() {
        return airTemp;
    }

    public void setAirTemp(String airTemp) {
        this.airTemp = airTemp;
    }

    public String getHumidity() {
        return Humidity;
    }

    public void setHumidity(String humidity) {
        Humidity = humidity;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public String getEnjoySport() {
        return isEnjoySport;
    }

    public void setEnjoySport(String enjoySport) {
        isEnjoySport = enjoySport;
    }
}
