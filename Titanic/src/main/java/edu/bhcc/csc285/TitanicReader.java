package edu.bhcc.csc285;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Matthew Dobler CSC-285
 */
public class TitanicReader {
    File file;
    Logger logger = LoggerFactory.getLogger(TitanicReader.class);

    /**
     * @param file a csv file with passenger information
     */
    public TitanicReader(File file) {
        this.file = file;
    }

    /**
     * This method reads the titanic csv file and returns the number of total passengers.
     *
     * @return the number of passengers
     */
    public int getNumPassengers() {
        int numPassengers = 0;
        Scanner fileOutput = null;
        try {
            fileOutput = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            logger.error("The file was not found");
            throw new RuntimeException(e);
        }
        while (fileOutput.hasNextLine()) {
            fileOutput.nextLine();
            numPassengers++;
        }
        fileOutput.close();
        return numPassengers - 1;
    }

    /**
     * This method reads the titanic csv file and returns the total number of first class passengers
     *
     * @return the number of first class passengers
     */
    public int getNumFirstClassPassengers() {
        int numFirstClass = 0;
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
            if (Integer.parseInt(temp[2]) == 1) {
                numFirstClass++;
            }
        }
        return numFirstClass;
    }

    /**
     * This method reads the titanic csv file and calculates the total number of second class passengers
     *
     * @return the number of second class passengers
     */
    public int getNumSecondClassPassengers() {
        int numSecondClass = 0;
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
            if (Integer.parseInt(temp[2]) == 2) {
                numSecondClass++;
            }
        }
        return numSecondClass;
    }

    /**
     * This method reads the titanic csv file and calculates the total number of third class passengers
     *
     * @return the number of third class passengers
     */
    public int getNumThirdClassPassengers() {
        int numThirdClass = 0;
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
            if (Integer.parseInt(temp[2]) == 3) {
                numThirdClass++;
            }
        }
        return numThirdClass;
    }

}
