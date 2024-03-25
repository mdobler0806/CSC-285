package edu.bhcc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.*;
import java.net.Socket;
import java.util.HashMap;


public class HandleWeatherRequest implements Runnable {
    private Socket socket;
    private InputStreamReader inputFromClient;
    private BufferedReader inputFromClientReader;
    private ObjectOutputStream outputObjectToClient;
    private Logger logger;
    private WeatherReader weatherReader;


    public HandleWeatherRequest(Socket socket, WeatherReader weatherReader) throws IOException
    {
        this.socket = socket;
        this.inputFromClient = new InputStreamReader(socket.getInputStream());
        this.inputFromClientReader = new BufferedReader(inputFromClient);
        this.outputObjectToClient = new ObjectOutputStream(socket.getOutputStream());
        this.logger =  LoggerFactory.getLogger(WeatherServer.class);
        this.weatherReader = weatherReader;
    }

    @Override
    public void run()
    {
        try {
            Weather weatherRequested = weatherReader.getWeather(inputFromClientReader.readLine());
            outputObjectToClient.writeObject(weatherRequested);
            logger.info("Weather: " + weatherRequested + " sent back to client");
            outputObjectToClient.flush();
            socket.close();
            logger.info("Socket: " + socket + " closed");

        } catch (IOException e) {
            logger.error("There was a problem when sending the data back to the client");
            throw new RuntimeException(e);
        }

    }
}
