package inventory;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class ProductFileHandler {

    private static final String FILE_NAME = "products.txt";

    public static void saveProducts(ArrayList<Product> products) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Product p : products) {
                bw.write(
                        p.getProductId() + "," +
                                p.getName() + "," +
                                p.getPrice() + "," +
                                p.getQuantity() + "," +
                                p.getProductionDate().getTime() + "," +
                                p.getExpirationDate().getTime() + "," +
                                p.getCategoryId() + "," +
                                p.getSupplierId() + "," +
                                p.getOfferId()
                );
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Product> loadProducts() {
        ArrayList<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                int productId = Integer.parseInt(d[0]);
                String name = d[1];
                double price = Double.parseDouble(d[2]);
                int quantity = Integer.parseInt(d[3]);
                Date productionDate = new Date(Long.parseLong(d[4]));
                Date expirationDate = new Date(Long.parseLong(d[5]));
                int categoryId = Integer.parseInt(d[6]);
                int supplierId = Integer.parseInt(d[7]);
                int offerId = Integer.parseInt(d[8]);

                products.add(new Product(
                        productId, name, price, quantity,
                        productionDate, expirationDate,
                        categoryId, supplierId, offerId
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }
}

