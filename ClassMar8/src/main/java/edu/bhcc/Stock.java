package edu.bhcc;

import java.io.Serializable;

/****************************
 *  @Author : Matthew Dobler"
 *  @Date    : 3/8/24"
 *  @File   : Stock"
 *  @Class   : CSC-"
 *****************************/
public class Stock implements Serializable {
    String tickerSymbol;
    double currentValue;
    double valueChange;
    double valuePercentChange;

    public Stock(String tickerSymbol, double currentValue, double valueChange, double valuePercentChange) {
        this.tickerSymbol = tickerSymbol;
        this.currentValue = currentValue;
        this.valueChange = valueChange;
        this.valuePercentChange = valuePercentChange;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "tickerSymbol='" + tickerSymbol + '\'' +
                ", currentValue=" + currentValue +
                ", valueChange=" + valueChange +
                ", valuePercentChange=" + valuePercentChange +
                '}';
    }
}
