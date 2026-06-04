package entities;

public class UsedProduct extends Product {
    private int manufactureYear;

    public UsedProduct(String name, double price, int quantity, int manufactureYear) {
        super(name, price, quantity);
        this.manufactureYear = manufactureYear;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }
    public double getTotalPrice() {
        return getPrice() * 0.8; // Aplicando um desconto de 20% para produtos usados
    }


}
