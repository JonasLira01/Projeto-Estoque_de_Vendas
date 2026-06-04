package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime moment;
    private String status;
    private Client client;
    private List<OrderItem> items;

    public Order(LocalDateTime moment, String status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.items = new ArrayList<>();
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        if (item != null) {
            items.add(item);
        } else {
            System.out.println("Item inválido!");
        }
    }

    public void removeItem(OrderItem item) {
        if (items.remove(item)) {
            System.out.println("Item removido com sucesso!");
        } else {
            System.out.println("Item não encontrado na lista!");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubTotal();
        }
        return total;
    }

}
