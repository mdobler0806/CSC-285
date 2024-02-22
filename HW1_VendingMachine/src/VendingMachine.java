/*******************************************
 * Name: Matthew Dobler
 * Class: CSC-285
 * Date: 2/9/2024
 * Assignment: HW1_VendingMachine
 *******************************************/


import java.util.HashMap;
import java.util.Stack;

/**
 * This class serves as the core of this package. Its purpose is to simulate a real life vending machine
 * object. The vending machine has {@link Slot}s which contain {@link Product}s. The user can purchase
 * the products in each of the slots. The vending machine keeps track of the sales it makes as well
 * as the number of products that have been stocked in it.
 */
public class VendingMachine {

    /**
     * This HashMap serves to connect a location name to the corresponding {@link Slot) in the
     * vending machine.}
     */
    private final HashMap<String, Slot> slots = new HashMap<>();

    /**
     * The amount of money the vending machine has made through sales.
     */
    private static double totalSales;

    /**
     * Creates a Vending Machine object.
     */
    public VendingMachine() {

    }

    /**
     * This method serves to stock the vending machine with {@link Slot}s that contain any number
     * of one {@link Product}.
     *
     * @param location    The lcoation name of the associated {@link Slot}.
     * @param productList A stack containing any number of one {@link Product}
     * @param unitPrice   The price of the {@link Product}
     */
    public void stockItems(String location, Stack<Product> productList, double unitPrice) {
        slots.put(location, new Slot(productList, unitPrice));
    }


    /**
     * This method prints out the current {@link Slot}s in the vending machine as well as
     * the type and number of {@link Product}s within each slot.
     */
    public void printInventory() {
        for (String key : slots.keySet()) {
            System.out.println(key);
            for (Product productList : slots.get(key).getProductList()) {
                System.out.println("- " + productList.productName);
            }
        }
    }


    /**
     * Simple accessor method to get the total sales of the vending machine.
     *
     * @return The total sales made by the vending machine.
     */
    public double getTotalSales() {
        return totalSales;
    }


    /**
     * This method serves to simulate the purchase process of the vending machine. It returns a
     * {@link VendingMachineOutput} object in order to simulate what the user of the vending machine
     * receives when purchasing a {@link Product} from the vending machine.
     *
     * @param location the location of the requested item.
     * @param amount   the amount of money put into the vending machine when the user tries to
     *                 purchase it.
     * @return a {@link VendingMachineOutput} object that represents what the user of a vending
     * machine gets when they purchase a {@link Product} from a vending machine.
     */
    public VendingMachineOutput purchase(String location, double amount) {

        Slot selectedSlot = slots.get(location);
        if (selectedSlot != null) {
            if (selectedSlot.getProductList().empty()) {
                throw new IllegalArgumentException("There are no products left");
            }
            double change = amount - selectedSlot.getPrice();
            if (change < 0) {
                throw new IllegalArgumentException("Not enough money to purchase");
            } else {
                totalSales += selectedSlot.getPrice();
                return new VendingMachineOutput(selectedSlot.getProductList().pop(), change);
            }
        } else {
            throw new IllegalArgumentException("Slot doesn't exist");
        }

    }
}
