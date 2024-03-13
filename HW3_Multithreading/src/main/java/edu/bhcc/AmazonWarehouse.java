package edu.bhcc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/****************************
 *  @Author : Matthew Dobler"
 *  @Date    : 3/8/24"
 *  @File   : AmazonWarehouse"
 *  @Class   : CSC-285"
 *****************************/

/**
 * The driver class for LoadingDock, RobotTask, and TruckTask.
 */
public class AmazonWarehouse {

    /**
     * Main method in which 1 loading dock, 3 robot tasks and 2 truck tasks are created
     * and the process of a real life loading dock is simulated.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        LoadingDock coolLoadingDock = new LoadingDock();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(new RobotTask(coolLoadingDock, "R1"));
        executor.execute(new RobotTask(coolLoadingDock, "R2"));
        executor.execute(new RobotTask(coolLoadingDock, "R3"));
        executor.execute(new TruckTask(coolLoadingDock, "T1"));
        executor.execute(new TruckTask(coolLoadingDock, "T2"));
    }

}
