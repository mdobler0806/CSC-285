/*******************************************
 * Name: Matthew Dobler
 * Class: CSC-285
 * Date: 2/9/2024
 * Assignment: HW1_VendingMachine
 *******************************************/
public class Snack extends Product {
    public Snack(String productName) {
        super(productName);
    }

    @Override
    public void consume() {
        System.out.println("Yum, you eat the Cliff Bar");
    }
}
