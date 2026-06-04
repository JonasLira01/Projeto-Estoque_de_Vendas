package entities;

public class ImportedProduct extends Product {
    private double customsTax;

    public ImportedProduct(String name, double price, int quantity, double customsTax) {
        super(name, price, quantity);
        this.customsTax = customsTax;
    }

    public double getCustomsTax() {
        return customsTax;
    }

    public void setCustomsTax(double customsTax) {
        this.customsTax = customsTax;
    }

    public double getTotalPrice() {
        return getPrice() + (getPrice() * customsTax / 100);
    }
    

}
