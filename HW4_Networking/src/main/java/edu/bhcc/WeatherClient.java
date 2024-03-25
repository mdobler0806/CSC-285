package edu.bhcc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

import java.net.*;


public class WeatherClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        String date = args[0];
        Socket socket = new Socket("localhost", 8000);

        //Client Output to server
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        BufferedWriter toServer = new BufferedWriter(outputStreamWriter);

        //Send date string to server
        System.out.println("Sending the date " + date);
        toServer.write(date + "\n");
        toServer.flush();

        //Getting server input to client
        ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());
        Weather requestedWeather = (Weather) fromServer.readObject();
        socket.close();
        System.out.println("Here is the weather: " + requestedWeather.toString());
    }
}
