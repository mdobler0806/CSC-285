package edu.bhcc;

/****************************
 *  @Author : Matthew Dobler"
 *  @Date    : 3/8/24"
 *  @File   : truckTask"
 *  @Class   : CSC-285"
 *****************************/

/**
 * A task class in which a truck in a loading dock is simulated.
 */
public class TruckTask implements Runnable {

    /**
     * The name of the truck.
     */
    String truckName;

    /**
     * The loading dock that the truck is associated with.
     */
    LoadingDock loadingDock;

    /**
     * Simple constructor for a truck task in which a LoadingDock object as well as the name of a truck
     * is passed.
     *
     * @param loadingDock The LoadingDock object that the truck will be working with.
     * @param truckName   The name of the truck.
     */
    public TruckTask(LoadingDock loadingDock, String truckName) {
        this.truckName = truckName;
        this.loadingDock = loadingDock;
    }

    /**
     * Defines the TruckTask's run method.
     * Once running, it continues infinitely, taking packages once there are 20 loaded up by a robot.
     * It sleeps in between every package "taking".
     */
    @Override
    public void run() {
        try {
            while (true) {
                loadingDock.takePackages(truckName, 20);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
