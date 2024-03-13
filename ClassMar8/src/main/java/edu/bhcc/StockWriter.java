package edu.bhcc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/****************************
 *  @Author : Matthew Dobler"
 *  @Date    : 3/8/24"
 *  @File   : StockWriter"
 *  @Class   : CSC-"
 *****************************/
public class StockWriter {
    FileOutputStream fileOutputStream;
    ObjectOutputStream objectOutputStream;
    Stock myStock;

    @Override
    public String toString() {
        return "StockWriter{" +
                "fileOutputStream=" + fileOutputStream +
                ", objectOutputStream=" + objectOutputStream +
                ", myStock=" + myStock +
                '}';
    }

    public StockWriter(File file, Stock myStock) throws IOException {
        this.fileOutputStream = new FileOutputStream(file);
        this.objectOutputStream = new ObjectOutputStream(fileOutputStream);
        this.myStock = myStock;
        objectOutputStream.writeObject(myStock);

    }
}
