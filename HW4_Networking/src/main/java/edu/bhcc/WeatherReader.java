package edu.bhcc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class WeatherReader {
    private File weatherData;
    private HashMap<String, Weather> weatherHashMap;

    public WeatherReader(File weatherData)
    {
        Scanner scanner = null;
        this.weatherHashMap = new HashMap<>();
        try
        {
            scanner = new Scanner(weatherData);
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        scanner.nextLine();
        while (scanner.hasNextLine())
        {
            String currLine = scanner.nextLine();
            String[] currLineSplit = currLine.split(",");
            weatherHashMap.put(currLineSplit[0], new Weather(
                    Double.parseDouble(currLineSplit[1]),
                    Double.parseDouble(currLineSplit[2]),
                    Double.parseDouble(currLineSplit[3]),
                    Double.parseDouble(currLineSplit[4]),
                    currLineSplit[5]));
        }
    }

    public Weather getWeather(String date)
    {
        return weatherHashMap.get(date);
    }
}
