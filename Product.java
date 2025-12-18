package inventory;

import java.util.Date;

public class Product {

    private int productId;
    private String name;
    private double price;
    private int quantity;
    private Date productionDate;
    private Date expirationDate;

    private int categoryId;
    private int supplierId;
    private int offerId;

    public Product() {}

    public Product(int productId, String name, double price, int quantity,
                   Date productionDate, Date expirationDate,
                   int categoryId, int supplierId, int offerId) {

        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.offerId = offerId;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
        if (price >= 0)
            this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0)
            this.quantity = quantity;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    @Override
    public String toString() {
        return productId + "," + name + "," + price + "," + quantity + ","
                + productionDate + "," + expirationDate + ","
                + categoryId + "," + supplierId + "," + offerId;
    }
}
