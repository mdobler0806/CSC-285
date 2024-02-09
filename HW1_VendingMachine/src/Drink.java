/*******************************************
 * Name: Matthew Dobler
 * Class: CSC-285
 * Date: 2/9/2024
 * Assignment: HW1_VendingMachine
 *******************************************/
public class Drink extends Product {
    public Drink(String drinkName) {
        super(drinkName);
    }

    @Override
    public void consume() {
        System.out.println("Yum, you drink the Diet Coke");

    }
}
