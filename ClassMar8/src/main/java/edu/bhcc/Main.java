package edu.bhcc;

import java.io.File;
import java.io.IOException;

/****************************
 *  @Author : Matthew Dobler"
 *  @Date    : 3/8/24"
 *  @File   : ${NAME}"
 *  @Class   : CSC-"
 *****************************/
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Hello world!");
        Stock myStock = new Stock("AAPL", 170.12, -4.98, 2.84);
        File myFile = new File("potato.raw");
        StockWriter stockWriter = new StockWriter(myFile,myStock);
        StockReader stockReader = new StockReader(myFile);
        Stock newStock = stockReader.getMyStock();
        System.out.println(myStock.toString());
        System.out.println(newStock.toString());
    }
}