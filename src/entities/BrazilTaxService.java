package entities;

public class BrazilTaxService implements Interface.Interface {
    @Override
    public double calculateTax(double price) {
        if (price <= 100.0) {
            return price * 0.2;
        } else {
            return price * 0.15;
        }
    }


}
