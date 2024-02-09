/*******************************************
 * Name: Matthew Dobler
 * Class: CSC-285
 * Date: 2/9/2024
 * Assignment: HW1_VendingMachine
 *******************************************/

import java.util.Stack;

public class Slot {
    private String location;
    private Stack<Product> productList;
    private double unitPrice;

    public Slot(String location, Stack<Product> productList, double unitPrice) {
        this.location = location;
        this.productList = productList;
        this.unitPrice = unitPrice;
    }

    public Stack<Product> getProductList() {
        return this.productList;
    }

    public double getPrice() {
        return this.unitPrice;
    }

    public String getLocation() {
        return this.location;
    }
}
