import edu.bhcc.Weather;
import edu.bhcc.WeatherReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

    /**
     * @author Matthew Dobler
     * Unit tests for WeatherReader's data reading and retrieving functionality.
     */
    class WeatherReaderTest {
        private WeatherReader weatherReader;

        @BeforeEach
        void setUp()
        {
            File testWeatherData = new File("src/main/resources/seattle-weather.csv");
            weatherReader = new WeatherReader(testWeatherData);
        }

        @Test
        void testGetWeather_ValidDate_ReturnsCorrectWeather()
        {
            //Using a date we know exists in the weather csv file
            String testDate = "2012-08-10";
            Weather weather = weatherReader.getWeather(testDate);

            assertAll("weather",
                    () -> assertNotNull(weather, "Weather should not be null for a valid date"),
                    () -> assertEquals(0.0, weather.getPrecipitation(), "Precipitation mismatch"),
                    () -> assertEquals(25.6, weather.getTempMax(), "Max temp mismatch"),
                    () -> assertEquals(12.2, weather.getTempMin(), "Min temp mismatch"),
                    () -> assertEquals(2.3, weather.getWind(), "Wind speed mismatch"),
                    () -> assertEquals("sun", weather.getWeather(), "Weather condition mismatch")
            );
        }

        @Test
        void testGetWeather_InvalidDate_ReturnsNull()
        {
            //Using an invalid date we know doesn't exist should return null
            String testDate = "2020-01-01";
            Weather weather = weatherReader.getWeather(testDate);

            assertNull(weather, "Weather should be null for an invalid date");
        }
    }
