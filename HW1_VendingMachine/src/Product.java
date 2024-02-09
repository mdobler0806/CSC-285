/*******************************************
 * Name: Matthew Dobler
 * Class: CSC-285
 * Date: 2/9/2024
 * Assignment: HW1_VendingMachine
 *******************************************/
public abstract class Product {
    public String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public abstract void consume();
}
