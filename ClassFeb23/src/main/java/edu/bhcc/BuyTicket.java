package edu.bhcc;

/****************************
 *  @Author : Matthew Dobler"
 *  @Date    : 2/23/24"
 *  @File   : BuyTicket"
 *  @Class   : CSC-285"
 *****************************/
public class BuyTicket implements Runnable{
    TicketMaster ticketMaster;

    public BuyTicket(TicketMaster ticketmaster)
    {
        this.ticketMaster = ticketmaster;
    }


    @Override
    public void run() {
        ticketMaster.buyTicket();
    }
}
