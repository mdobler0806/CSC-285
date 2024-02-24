package edu.bhcc.csc285;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class reads through a CSV file containing Titanic passenger information. It uses the
 * passenger list to enumerate the number of passengers on the whole ship as well as in each
 * "class" on the ship.
 *
 * @author Matthew Dobler CSC-285
 */
public class TitanicReader {
    /**
     * A file variable to store the Titanic CSV file.
     */
    File file;

    /**
     * Simple logger for logging :) Using the Simple Logger Facade 4 Java.
     */
    Logger logger = LoggerFactory.getLogger(TitanicReader.class);

    /**
     * Stores the total number of passengers.
     */
    int numPassengers;

    /**
     * Stores the number of first class passengers on the ship.
     */
    int numFirstClassPassengers;

    /**
     * Stores the number of second class passengers on the ship.
     */
    int numSecondClassPassengers;

    /**
     * Stores the number of third class passengers on the ship.
     */
    int numThirdClassPassengers;

    /**
     * The constructor does the heavy lifting in {@code TitanicReader}.
     * <p>
     * Instantiates the TitanicReader class while simultaneously reading through the passed CSV
     * file and counting the number of first, second, and third class passengers. Then saves these
     * numbers to their respective instance variables;
     *
     * @param file A csv file with passenger information
     */
    public TitanicReader(File file) {
        this.file = file;
        Scanner fileOutput = null;
        try {
            fileOutput = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            logger.error("The file was not found");
            throw new RuntimeException(e);
        }
        fileOutput.nextLine();
        while (fileOutput.hasNextLine()) {
            String[] temp = fileOutput.nextLine().split(",");
            numPassengers++;
            if (Integer.parseInt(temp[2]) == 1) {
                numFirstClassPassengers++;
            }
            if (Integer.parseInt(temp[2]) == 2) {
                numSecondClassPassengers++;
            }
            if (Integer.parseInt(temp[2]) == 3) {
                numThirdClassPassengers++;
            }
        }
        fileOutput.close();
    }

    /**
     * Accessor that returns the instance variable {@link #numPassengers}.
     *
     * @return the number of passengers
     */
    public int getNumPassengers() {
        return numPassengers;
    }

    /**
     * Accessor that returns the instance variable, {@link #numFirstClassPassengers}.
     *
     * @return the number of first class passengers
     */
    public int getNumFirstClassPassengers() {
        return numFirstClassPassengers;
    }

    /**
     * Accessor that returns the instance variable, {@link #numSecondClassPassengers}.
     *
     * @return the number of second class passengers
     */
    public int getNumSecondClassPassengers() {
        return numSecondClassPassengers;
    }

    /**
     * Accessor that returns the instance variable, {@link #numThirdClassPassengers}.
     *
     * @return the number of third class passengers
     */
    public int getNumThirdClassPassengers() {
        return numThirdClassPassengers;
    }
}
