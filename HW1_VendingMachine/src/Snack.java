/*******************************************
 * Name: Matthew Dobler
 * Class: CSC-285
 * Date: 2/9/2024
 * Assignment: HW1_VendingMachine
 *******************************************/

/**
 * Child class of {@link Product}, Snack that allows the creation
 * of a snack. This snack can be given a name and can be consumed.
 */
public class Snack extends Product {

    /**
     * Constructs a snack object with a specified name in the parameter.
     *
     * @param productName The requested name of the Snack.
     */
    public Snack(String productName) {
        super(productName);
    }

    /**
     * Simple method that allows "consumption" of the snack. This simply prints
     * out a nice little message referencing the name of the snack.
     */
    @Override
    public void consume() {
        System.out.println("Yum, you eat the " + productName);
    }
}
