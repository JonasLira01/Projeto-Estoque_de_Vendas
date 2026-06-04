package entities;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity += quantity;
        } else {
            System.out.println("Quantidade inválida para adicionar ao estoque!");
        }
    }

    public void removeQuantity(int quantity) {
        if (quantity > 0 && quantity <= this.quantity) {
            this.quantity -= quantity;
        } else if (quantity > this.quantity) {
            System.out.println("Quantidade insuficiente em estoque!");
        } else {
            System.out.println("Quantidade inválida para remover do estoque!");
        }
    }
    public double totalValueInStock() {
        return price * quantity;
    }

}
