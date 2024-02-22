/*******************************************
 * Name: Matthew Dobler
 * Class: CSC-285
 * Date: 2/9/2024
 * Assignment: HW1_VendingMachine
 *******************************************/

/**
 * Abstract class to be used in making many different products. For example {@link Drink} and {@link Snack}
 * classes.
 */
public abstract class Product {
    /**
     * The name of the product.
     */
    public String productName;

    /**
     * Constructor for the child classes of Product, that requires
     * them to name their product.
     *
     * @param productName The name of the product. e.g. Cliff Bar
     */
    public Product(String productName) {
        this.productName = productName;
    }

    /**
     * Allows product to be consumed which should print out a message
     * when implemented in child classes. e.g "Yum"
     */
    public abstract void consume();


}
