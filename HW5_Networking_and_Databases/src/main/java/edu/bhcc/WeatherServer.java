package edu.bhcc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author Matthew Dobler
 * This class simulates a weather server which contains weather data that can be requested from
 * a client.
 */
public class WeatherServer {
    private static final int DEFAULT_NUM_THREADS = 6;

    /**
     * Creates a server and utilizes multithreading to handle multiple clients' requests for weather
     * data on a specific data passed from the client to the server.
     *
     * @param args Not used in this program.
     * @throws IOException           Occurs if a socket cannot be properly created or connected to.
     * @throws FileNotFoundException Occurs if a file cannot be located as specified.
     */
    public static void main(String[] args) throws IOException, FileNotFoundException
    {
        Logger logger = LoggerFactory.getLogger(WeatherServer.class);
        File weatherData = new File("src/main/resources/seattle-weather.csv");

        System.out.println("Starting server at: " + new Date());

        //Server socket setup
        ServerSocket serverSocket = new ServerSocket(8000);
        logger.info("Server Socket: " + serverSocket + " opened.");

        //New thread pool
        ExecutorService executor = Executors.newFixedThreadPool(DEFAULT_NUM_THREADS);

        //Create a weatherReader object so the data is readily available for each task
        WeatherReader weatherReader = new WeatherReader(weatherData);

        while (true)
        {
            //Listen for client requests
            Socket socket = serverSocket.accept();
            logger.info("Connected with socket: " + socket);
            HandleWeatherRequest weatherRequest = new HandleWeatherRequest(socket, weatherReader);
            executor.execute(weatherRequest);
        }
    }
}
