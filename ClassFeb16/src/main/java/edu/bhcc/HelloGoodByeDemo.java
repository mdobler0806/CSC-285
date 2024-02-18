package edu.bhcc;

/**
 * @Author : Matthew Dobler",
 * @Date : 2/16/24",
 * @File : HelloGoodByeDemo",
 * Class   : CSC-242",
 */
public class HelloGoodByeDemo {
    public static void main(String[] args)
    {
        Runtime runTime = Runtime.getRuntime();
        System.out.println("Available Processors:  " + runTime.availableProcessors() + runTime.maxMemory());
        Runnable hello = new PrintHello();
        Runnable goodbye = new PrintGoodbye();

        Thread threadA = new Thread(hello);
        Thread threadB = new Thread(goodbye);


        threadA.start();
        threadB.start();

    }

}
