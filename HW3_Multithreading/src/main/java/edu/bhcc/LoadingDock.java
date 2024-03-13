package edu.bhcc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/****************************
 *  @Author : Matthew Dobler"
 *  @Date    : 3/8/24"
 *  @File   : LoadingDock"
 *****************************/

/**
 * The LoadingDock class simulates a loading dock in which packages can be added to trucks,
 * and then subsequently taken away when 20 packages are loaded into a truck. This class is thread-safe.
 */
public class LoadingDock {
    private Lock lock = new ReentrantLock();
    private Condition newPackages = lock.newCondition();
    private int numPackages;

    /**
     * Add Packages to the Loading Dock.
     */
    public void addPackages(String robotName, int numPackagesToAdd) {
        lock.lock();
        numPackages += numPackagesToAdd;
        System.out.println("[Robot " + robotName + "] Added " + numPackagesToAdd + " packages. Total: " + numPackages);
        newPackages.signalAll();
        lock.unlock();
    }

    /**
     * Take Packages from the Loading Dock.
     */
    public void takePackages(String truckName, int numPackagesToTake) {
        lock.lock();
        try {
            while (numPackages < 20) {
                System.out.println("[Truck " + truckName + "] is waiting for 20 packages but there is only:  " + numPackages);
                newPackages.await();
            }
            System.out.println("[Truck " + truckName + "] is leaving with " + numPackagesToTake + " packages.");
            numPackages -= numPackagesToTake;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

}
