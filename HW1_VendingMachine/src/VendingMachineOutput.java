/*******************************************
 * Name: Matthew Dobler
 * Class: CSC-285
 * Date: 2/9/2024
 * Assignment: HW1_VendingMachine
 *******************************************/

/**
 * A simple class that serves to simulate what a real life {@link VendingMachine} user receives
 * when they  purchase a {@link Product}.
 */
public class VendingMachineOutput {
    /**
     * The {@link Product} that the user receives when they {@link VendingMachine#purchase(String, double)}
     * an item from the {@link VendingMachine}.
     */
    public Product product;

    /**
     * The change that is received when the user {@link VendingMachine#purchase}s an item from the
     * {@link VendingMachine}
     */
    public double change;

    /**
     * Constructs a {@code VendingMachineOutput} object that serves to represent what a user receives
     * when they {@link VendingMachine#purchase} an item from a {@link VendingMachine}.
     *
     * @param product The {@link Product} that is received when purchasing an item.
     * @param change  The change that is received when purchasing a {@link Product} from the vending
     *                machine.
     */
    public VendingMachineOutput(Product product, double change) {
        this.product = product;
        this.change = change;
    }

}
