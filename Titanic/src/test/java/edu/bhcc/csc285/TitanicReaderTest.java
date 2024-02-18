package edu.bhcc.csc285;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class TitanicReaderTest {

    @Test
    void getNumPassengers() {
        TitanicReader titanicTest = new TitanicReader(new File("src/test/test_data/titanic.csv"));
        int answer = titanicTest.getNumPassengers();
        assertEquals(891, answer);
    }

    @Test
    void getNumFirstClassPassengers() {
        TitanicReader titanicTest = new TitanicReader(new File("src/test/test_data/titanic.csv"));
        int answer = titanicTest.getNumFirstClassPassengers();
        assertEquals(216, answer);
    }

    @Test
    void getNumSecondClassPassengers() {
        TitanicReader titanicTest = new TitanicReader(new File("src/test/test_data/titanic.csv"));
        int answer = titanicTest.getNumSecondClassPassengers();
        assertEquals(184, answer);

    }

    @Test
    void getNumThirdClassPassengers() {
        TitanicReader titanicTest = new TitanicReader(new File("src/test/test_data/titanic.csv"));
        int answer = titanicTest.getNumThirdClassPassengers();
        assertEquals(491, answer);
    }
}