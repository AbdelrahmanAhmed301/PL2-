package inventory;

import java.util.ArrayList;
import java.util.Date;

public class OrderService {

    private ArrayList<Order> orders = new ArrayList<>();

    public Order createOrder(int orderId, Client client) {
        Order order = new Order(orderId, client, new Date());
        orders.add(order);
        return order;
    }

    public Order getOrderById(int orderId) {
        for (Order o : orders) {
            if (o.getOrderId() == orderId)
                return o;
        }
        return null;
    }

    public void addItemToOrder(int orderId, Product product, int quantity) {
        Order order = getOrderById(orderId);
        if (order != null) {
            OrderItem item = new OrderItem(product, quantity);
            order.addItem(item);
        }
    }

    public boolean cancelOrder(int orderId) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setStatus("CANCELLED");
            return true;
        }
        return false;
    }

    public boolean completeOrder(int orderId) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setStatus("PAID");
            return true;
        }
        return false;
    }

    public ArrayList<Order> getOrdersByClient(Client client) {
        ArrayList<Order> result = new ArrayList<>();
        for (Order o : orders) {
            if (o.getClient().equals(client))
                result.add(o);
        }
        return result;
    }

    public ArrayList<Order> getAllOrders() {
        return orders;
    }
}

