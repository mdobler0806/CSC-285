public abstract class Product {
    public String productName;

    public Product(String productName) {
        this.productName = productName;
    }
    public abstract void consume();
}
