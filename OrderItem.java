package inventory;

public class OrderItem {

    private Product product;
    private int quantity;
    private double price;

    public OrderItem() {}

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.price = product.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0)
            this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getSubTotal() {
        return price * quantity;
    }
}

