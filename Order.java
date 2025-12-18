package inventory;

import java.util.ArrayList;
import java.util.Date;

public class Order {

    private int orderId;
    private Client client;
    private Date orderDate;
    private double totalAmount;
    private String status;
    private ArrayList<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public Order(int orderId, Client client, Date orderDate) {
        this.orderId = orderId;
        this.client = client;
        this.orderDate = orderDate;
        this.status = "NEW";
        this.items = new ArrayList<>();
        this.totalAmount = 0;
    }

    public int getOrderId() {
        return orderId;
    }

    public Client getClient() {
        return client;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addItem(OrderItem item) {
        items.add(item);
        totalAmount += item.getSubTotal();
    }
}

