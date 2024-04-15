package edu.bhcc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The WeatherReader class is responsible for reading weather data from a CSV file and storing it
 * in a HashMap. This allows quick access to weather information by date.
 */
public class WeatherReader {
    private File weatherData; //The CSV file containing the weather data
    private HashMap<String, Weather> weatherHashMap;//Hashmap to store weather data by date

    /**
     * Constructs a WeatherReader object and sorts the weather data CSV file into a hashmap by date.
     *
     * @param weatherData The file object for the CSV file containing weather data.
     */
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

    /**
     * Gets weather information for a specific date.
     *
     * @param date The date string which will be used to find the requested weather data in the hashmap..
     * @return A Weather object containing the weather information for the specified date.
     */
    public Weather getWeather(String date)
    {
        return weatherHashMap.get(date);
    }
}
