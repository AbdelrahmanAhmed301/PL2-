package inventory;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class OrderFileHandler {

    private static final String ORDER_FILE = "orders.txt";
    private static final String ITEM_FILE = "order_items.txt";

    public static void saveOrders(ArrayList<Order> orders) {
        try (
                BufferedWriter obw = new BufferedWriter(new FileWriter(ORDER_FILE));
                BufferedWriter ibw = new BufferedWriter(new FileWriter(ITEM_FILE))
        ) {
            for (Order o : orders) {

                obw.write(
                        o.getOrderId() + "," +
                                o.getClient().getUserId() + "," +
                                o.getOrderDate().getTime() + "," +
                                o.getStatus() + "," +
                                o.getTotalAmount()
                );
                obw.newLine();

                for (OrderItem item : o.getItems()) {
                    ibw.write(
                            o.getOrderId() + "," +
                                    item.getProduct().getProductId() + "," +
                                    item.getQuantity() + "," +
                                    item.getPrice()
                    );
                    ibw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Order> loadOrders(
            ArrayList<Client> clients,
            ArrayList<Product> products) {

        ArrayList<Order> orders = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ORDER_FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                int orderId = Integer.parseInt(d[0]);
                int clientId = Integer.parseInt(d[1]);
                Date orderDate = new Date(Long.parseLong(d[2]));
                String status = d[3];

                Client client = findClientById(clients, clientId);
                if (client == null) continue;

                Order order = new Order(orderId, client, orderDate);
                order.setStatus(status);

                orders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(ITEM_FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                int orderId = Integer.parseInt(d[0]);
                int productId = Integer.parseInt(d[1]);
                int quantity = Integer.parseInt(d[2]);
                double price = Double.parseDouble(d[3]);

                Order order = findOrderById(orders, orderId);
                Product product = findProductById(products, productId);

                if (order != null && product != null) {
                    OrderItem item = new OrderItem(product, quantity);
                    order.addItem(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return orders;
    }

    private static Client findClientById(ArrayList<Client> clients, int id) {
        for (Client c : clients) {
            if (c.getUserId() == id)
                return c;
        }
        return null;
    }

    private static Product findProductById(ArrayList<Product> products, int id) {
        for (Product p : products) {
            if (p.getProductId() == id)
                return p;
        }
        return null;
    }

    private static Order findOrderById(ArrayList<Order> orders, int id) {
        for (Order o : orders) {
            if (o.getOrderId() == id)
                return o;
        }
        return null;
    }
}
