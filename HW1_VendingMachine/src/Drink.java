/*******************************************
 * Name: Matthew Dobler
 * Class: CSC-285
 * Date: 2/9/2024
 * Assignment: HW1_VendingMachine
 *******************************************/

/**
 * The drink class serves to create a "drink" which the user can
 * {@link #consume()}. It inherits from the abstract {@link Product} class.
 */
public class Drink extends Product {

    /**
     * Creates a drink with a name that is specified in the constructor parameter.
     *
     * @param drinkName The name for the drink.
     */
    public Drink(String drinkName) {
        super(drinkName);
    }

    /**
     * Simple method that allows "consumption" of the drink. The method just prints out
     * a nice little message referencing the name of the drink.
     */
    @Override
    public void consume() {
        System.out.println("Yum, you drink the " + productName);
    }
}
