/*******************************************
 * Name: Matthew Dobler
 * Class: CSC-285
 * Date: 2/9/2024
 * Assignment: HW1_VendingMachine
 *******************************************/

import java.util.Stack;

/**
 * This class' purpose is to represent a "slot" in the vending machine. It can contain any number of one {@link Product}.
 */
public class Slot {

    /**
     * A Stack that stores {@link Product} objects in it. This simulates the vending machine
     * slot holding products in real life.
     */
    private final Stack<Product> productList;

    /**
     * The price of the product stored in the slot.
     */
    private final double unitPrice;

    /**
     * Creates a slot object with a product inside that has a specific price.
     *
     * @param productList The product that will be stored in this slot of the vending machine.
     * @param unitPrice   The price of the product.
     */
    public Slot(Stack<Product> productList, double unitPrice) {
        this.productList = productList;
        this.unitPrice = unitPrice;
    }

    /**
     * Simple accessor method to get the stack, {@code productList}.
     *
     * @return the stack containing the {@link Product} objects in the slot.
     */
    public Stack<Product> getProductList() {
        return this.productList;
    }

    /**
     * Simple accessor method to get the price  of the associated {@code Product}
     *
     * @return the price of the {@link Product}
     */
    public double getPrice() {
        return this.unitPrice;
    }
}
