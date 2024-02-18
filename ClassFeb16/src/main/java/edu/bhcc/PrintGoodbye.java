package edu.bhcc;

/**
 * @Author : Matthew Dobler",
 * @Date : 2/16/24",
 * @File : PrintGoodbye",
 * Class   : CSC-242",
 */
public class PrintGoodbye implements Runnable {
    String goodbye = "goodbye";
    int goodbyeCounter = 0;

    public void run()
    {
        for(int i = 0; i < 1000; i++)
        {
            System.out.print(this.goodbye);
            goodbyeCounter++;
            if(i % 25 == 0)
            {
                System.out.print("GOODBYECOUNTER = " + goodbyeCounter);
            }
        }
    }

}
