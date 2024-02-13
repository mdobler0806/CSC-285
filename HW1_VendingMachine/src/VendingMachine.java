/*******************************************
 * Name: Matthew Dobler
 * Class: CSC-285
 * Date: 2/9/2024
 * Assignment: HW1_VendingMachine
 *******************************************/

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 */
public class VendingMachine {
    private ArrayList<Slot> slots = new ArrayList<>();
    private static double totalSales;

    /**
     * This method takes the parameters provided and creates a slot item from that. It then adds
     * that slot object to a an array of slots.
     * @param location
     * @param productList
     * @param unitPrice
     */
    public void stockItems(String location, Stack<Product> productList, double unitPrice) {
        slots.add(new Slot(location, productList, unitPrice));
    }

    public void printInventory() {
        for (Slot slot : slots) {
            System.out.println(slot.getLocation());
            for (int i = 0; i < slot.getProductList().size(); i++) {
                System.out.println("-" + slot.getProductList().peek().productName);
            }
        }
    }

    public double getTotalSales() {
        return totalSales;
    }

    public VendingMachineOutput purchase(String location, double amount) {
        for (Slot slot : slots) {
            if (slot.getLocation().equalsIgnoreCase(location)) {
                if (slot.getProductList().empty()) {
                    throw new IllegalArgumentException("There are no products left");
                }
                Product selectedProduct = slot.getProductList().pop();
                double change = amount - slot.getPrice();
                if (change < 0) {
                    throw new IllegalArgumentException("Not enough money to purchase :(");
                } else {
                    totalSales += slot.getPrice();
                    return new VendingMachineOutput(selectedProduct, change);
                }
            }
        }
        throw new IllegalArgumentException("Slot doesn't exist");
    }
}
