package inventory;

import java.util.ArrayList;

public class AdminManager {

    private ArrayList<Supplier> suppliers = new ArrayList<>();
    private ArrayList<Category> categories = new ArrayList<>();
    private ArrayList<Offer> offers = new ArrayList<>();

    public void addSupplier(Supplier s) {
        suppliers.add(s);
    }

    public void addCategory(Category c) {
        categories.add(c);
    }

    public void addOffer(Offer o) {
        offers.add(o);
    }

    public boolean deleteSupplier(int id) {
        return suppliers.removeIf(s -> s.getSupplierId() == id);
    }

    public boolean deleteCategory(int id) {
        return categories.removeIf(c -> c.getCategoryId() == id);
    }

    public boolean deleteOffer(int id) {
        return offers.removeIf(o -> o.getOfferId() == id);
    }

    public ArrayList<Supplier> getAllSuppliers() {
        return suppliers;
    }

    public ArrayList<Category> getAllCategories() {
        return categories;
    }

    public ArrayList<Offer> getAllOffers() {
        return offers;
    }
}

