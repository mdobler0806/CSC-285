package edu.bhcc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeatherServer {
    private static final int DEFAULT_NUM_THREADS = 6;

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
