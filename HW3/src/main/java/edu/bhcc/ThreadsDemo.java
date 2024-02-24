package edu.bhcc;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/********
 * @Author : Matthew Dobler
 * @Date : 2/22/24
 * @File : ThreadsDemo
 * Class   : CSC-242
 */
public class ThreadsDemo{

    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        TicketMaster ticketMaster = new TicketMaster(1000);
        for(int i = 0; i < 1000; i++)
        {

            executor.execute(new BuyTicket(ticketMaster));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
