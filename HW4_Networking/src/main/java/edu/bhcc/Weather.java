package edu.bhcc;

import java.io.Serializable;

/**
 * Represents weather conditions for a specific day, including precipitation, maximum and minimum
 * temperatures, wind speed, and general weather conditions.
 */
public class Weather implements Serializable {

    private double precipitation; // Precipitation amount
    private double tempMax; // Maximum temperature
    private double tempMin; // Minimum temperature
    private double wind; // Wind speed
    private String weather; // General weather condition

    /**
     * Constructs a new Weather object.
     *
     * @param precipitation the amount of precipitation
     * @param tempMax the maximum temperature
     * @param tempMin the minimum temperature
     * @param wind the wind speed
     * @param weather the general weather condition
     */
    public Weather(double precipitation, double tempMax, double tempMin, double wind, String weather)
    {
        this.precipitation = precipitation;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.wind = wind;
        this.weather = weather;
    }


    public double getPrecipitation()
    {
        return precipitation;
    }

    public void setPrecipitation(double precipitation)
    {
        this.precipitation = precipitation;
    }

    public double getTempMax()
    {
        return tempMax;
    }

    public void setTempMax(double tempMax)
    {
        this.tempMax = tempMax;
    }

    public double getTempMin()
    {
        return tempMin;
    }

    public void setTempMin(double tempMin)
    {
        this.tempMin = tempMin;
    }

    public double getWind()
    {
        return wind;
    }

    public void setWind(double wind)
    {
        this.wind = wind;
    }

    public String getWeather()
    {
        return weather;
    }

    public void setWeather(String weather)
    {
        this.weather = weather;
    }

    /**
     * Simple toString method.
     * @return String with all the info contained in a weather object.
     */
    @Override
    public String toString()
    {
        return "Weather{" +
                "precipitation=" + precipitation +
                ", tempMax=" + tempMax +
                ", tempMin=" + tempMin +
                ", wind=" + wind +
                ", weather='" + weather + '\'' +
                '}';
    }
}
