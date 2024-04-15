package edu.bhcc;

import java.io.*;
import java.net.*;


/**
 * @author Matthew Dobler
 * Class representing the client who requests weather data from the server
 */
public class WeatherClient {

    /**
     * The main method creates a client socket and uses that socket to get weather information
     * for a specific date from the server socket.
     *
     * @param args This class does not use command line arguments.
     * @throws IOException            This exception is thrown if the input stream is not possible to acquire from
     *                                the client or server socket.
     * @throws ClassNotFoundException This exception is thrown if an object is not received from the server.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        String date = "2012-08-10";
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
