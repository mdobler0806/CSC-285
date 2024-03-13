package edu.bhcc;

import java.io.*;

/****************************
 *  @Author : Matthew Dobler"
 *  @Date    : 3/8/24"
 *  @File   : StockReader"
 *  @Class   : CSC-"
 *****************************/
public class StockReader {
    FileInputStream fileInputStream;
    ObjectInputStream objectInputStream;
    Stock myStock;

    public StockReader(File file) throws IOException, ClassNotFoundException {
        this.fileInputStream = new FileInputStream(file);
        this.objectInputStream = new ObjectInputStream(fileInputStream);
        this.myStock = (Stock)objectInputStream.readObject();
    }

    @Override
    public String toString() {
        return "StockReader{" +
                "fileInputStream=" + fileInputStream +
                ", objectInputStream=" + objectInputStream +
                ", myStock=" + myStock +
                '}';
    }

    public Stock getMyStock() {
        return myStock;
    }
}
