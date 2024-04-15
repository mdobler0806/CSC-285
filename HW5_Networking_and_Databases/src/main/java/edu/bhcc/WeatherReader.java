package edu.bhcc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.text.DecimalFormat;

/**
 * The WeatherReader class is responsible for reading weather data from a CSV file and storing it
 * in a mySQL database. This allows quick access to weather information by date.
 *
 * @author MatthewDobler
 */
public class WeatherReader {
    private File weatherData; //The CSV file containing the weather data
    private String JDBC_URL = "jdbc:mysql://localhost/Weather";
    private String USERNAME = "user";
    private String PASSWORD = "password";
    private Connection conn;
    private Logger logger;


    /**
     * Constructs a WeatherReader object that establishes the connection to the mysql database.
     *
     * @param weatherData The CSV file containing seattle weather data.
     */
    public WeatherReader(File weatherData)
    {
        this.logger = LoggerFactory.getLogger(WeatherReader.class);
        try
        {
            //Connect to mySQL database
            this.conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            importDataFromCSV(weatherData); //Import data when constructing
        } catch (SQLException e)
        {
            logger.error("Database connection error", e);
            throw new RuntimeException("Failed to connect to the database.", e);
        }
    }

    /**
     * Imports the weather data from CSV file to the mySQL database.
     *
     * @param weatherData The csv file containing seattle weather data
     */
    private void importDataFromCSV(File weatherData)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(weatherData)))
        {
            String line;
            reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null)
            {
                String[] data = line.split(",");

                String sql = "INSERT INTO weather_data (date, precipitation, temp_max, temp_min, wind, weather) " +
                        "VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE date=VALUES(date)";
                try (PreparedStatement statement = conn.prepareStatement(sql))
                {
                    statement.setDate(1, java.sql.Date.valueOf(data[0]));
                    statement.setDouble(2, Double.parseDouble(data[1]));
                    statement.setDouble(3, Double.parseDouble(data[2]));
                    statement.setDouble(4, Double.parseDouble(data[3]));
                    statement.setDouble(5, Double.parseDouble(data[4]));
                    statement.setString(6, data[5]);

                    statement.executeUpdate();
                } catch (SQLException e)
                {
                    logger.error("Database access error", e);
                    throw new RuntimeException("Database access error", e);
                }
            }
        } catch (Exception e)
        {
            logger.error("File reader error", e);
            throw new RuntimeException("File reader error, cannot continue", e);
        }
    }

    /**
     * Retrieves the weather data for a specific date from the database.
     *
     * @param date the date for which weather data is requested (in the format of "yyyy-MM-dd")
     * @return the Weather object containing the weather data for the specified date, or null if no data is found
     */
    public Weather getWeather(String date)
    {
        DecimalFormat df = new DecimalFormat("##.####");
        String sql = "SELECT * FROM weather_data WHERE date = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql))
        {
            statement.setDate(1, java.sql.Date.valueOf(date));
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                return new Weather(
                        rs.getDouble("precipitation"),
                        rs.getDouble("temp_max"),
                        rs.getDouble("temp_min"),
                        rs.getDouble("wind"),
                        rs.getString("weather")
                );
            }
        } catch (SQLException e)
        {
            logger.error("Database access error", e);
            throw new RuntimeException("Database access error, cannot continue", e);
        }
        return null;
    }
}
