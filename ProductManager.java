package inventory;

import java.util.ArrayList;
import java.util.Date;

public class ProductManager {

    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public boolean updateProduct(int id, String name, double price, int quantity) {
        Product p = searchById(id);

        if (p == null)
            return false;

        if (name != null)
            p.setName(name);

        if (price >= 0)
            p.setPrice(price);

        if (quantity >= 0)
            p.setQuantity(quantity);

        return true;
    }

    public boolean deleteProduct(int id) {
        return products.removeIf(p -> p.getProductId() == id);
    }

    public Product searchById(int id) {
        for (Product p : products) {
            if (p.getProductId() == id)
                return p;
        }
        return null;
    }

    public Product searchByName(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name))
                return p;
        }
        return null;
    }

    public ArrayList<Product> searchByProductionDate(Date date) {
        ArrayList<Product> result = new ArrayList<>();

        for (Product p : products) {
            if (p.getProductionDate().equals(date))
                result.add(p);
        }
        return result;
    }

    public ArrayList<Product> searchByExpirationDate(Date date) {
        ArrayList<Product> result = new ArrayList<>();

        for (Product p : products) {
            if (p.getExpirationDate().equals(date))
                result.add(p);
        }
        return result;
    }

    public ArrayList<Product> getNearExpiryProducts(int days) {
        ArrayList<Product> near = new ArrayList<>();
        Date today = new Date();

        for (Product p : products) {
            long diff = p.getExpirationDate().getTime() - today.getTime();
            long diffDays = diff / (1000 * 60 * 60 * 24);

            if (diffDays <= days)
                near.add(p);
        }
        return near;
    }

    public ArrayList<Product> lowQuantityProducts(int limit) {
        ArrayList<Product> low = new ArrayList<>();

        for (Product p : products) {
            if (p.getQuantity() <= limit)
                low.add(p);
        }
        return low;
    }

    public ArrayList<Product> getAllProducts() {
        return products;
    }
}
