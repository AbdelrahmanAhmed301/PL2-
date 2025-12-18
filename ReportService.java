package inventory;

import java.util.ArrayList;

public class ReportService {

    public double calculateTotalProfit(ArrayList<Order> orders) {
        double profit = 0;

        for (Order o : orders) {
            if (o.getStatus().equals("PAID")) {
                profit += o.getTotalAmount();
            }
        }
        return profit;
    }

    public ArrayList<Order> getPaidOrders(ArrayList<Order> orders) {
        ArrayList<Order> result = new ArrayList<>();

        for (Order o : orders) {
            if (o.getStatus().equals("PAID")) {
                result.add(o);
            }
        }
        return result;
    }

    public ArrayList<Order> getOrdersByClient(Client client, ArrayList<Order> orders) {
        ArrayList<Order> result = new ArrayList<>();

        for (Order o : orders) {
            if (o.getClient().equals(client)) {
                result.add(o);
            }
        }
        return result;
    }

    public ArrayList<Product> getLowStockProducts(ArrayList<Product> products, int limit) {
        ArrayList<Product> low = new ArrayList<>();

        for (Product p : products) {
            if (p.getQuantity() <= limit) {
                low.add(p);
            }
        }
        return low;
    }
}
