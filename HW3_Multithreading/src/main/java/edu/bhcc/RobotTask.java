package edu.bhcc;

import java.util.Random;

/****************************
 *  @Author : Matthew Dobler"
 *  @Date    : 3/8/24"
 *  @File   : RobotTask"
 *  @Class   : CSC-285"
 *****************************/

/**
 * A task class to be used in multithreading. It utilizes the methods defined in LoadingDock to
 * simulate a robot who adds packages to a truck in an Amazon warehouse.
 */
public class RobotTask implements Runnable {
    /**
     * The Loading dock that the robot will work with to add packages to the trucks.
     */
    LoadingDock loadingDock;

    /**
     * The name of the robot
     */
    String robotName;

    /**
     * An object of type Random that will be used to generate
     * random numbers of packages to add to the truck.
     */
    Random rand = new Random();

    /**
     * Simple constructor to set up the Robot object's loading dock and robotname variables.
     *
     * @param loadingDock an object of type LoadingDock that the Robot will be working in.
     * @param robotName   the desired name for the robot.
     */
    public RobotTask(LoadingDock loadingDock, String robotName) {
        this.loadingDock = loadingDock;
        this.robotName = robotName;
    }

    /**
     * Defines the task's run method,
     * Once running, it runs infinitely, adding packages to the truck in loadingDock in random amounts.
     * It sleeps in between package additions.
     */
    @Override
    public void run() {
        try {
            while (true) {
                loadingDock.addPackages(robotName, rand.nextInt(1, 4));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
