package edu.bhcc;

/**
 * @Author : Matthew Dobler",
 * @Date : 2/16/24",
 * @File : PrintHello",
 * Class   : CSC-242",
 */
public class PrintHello implements Runnable{
    private String hello = "hello";
    private int helloCounter = 0;

    public void run()
    {
        for(int i = 0; i < 1000; i++)
        {
            System.out.print(this.hello);
            helloCounter++;
            if(i % 25 == 0)
            {
                System.out.print("HELLOCOUNTER = " + helloCounter);
            }
        }
    }
}
