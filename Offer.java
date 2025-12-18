package inventory;

import java.util.Date;

public class Offer {

    private int offerId;
    private String title;
    private double discountRate;
    private Date startDate;
    private Date endDate;

    public Offer() {}

    public Offer(int offerId, String title, double discountRate,
                 Date startDate, Date endDate) {

        this.offerId = offerId;
        this.title = title;
        this.discountRate = discountRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        if (discountRate >= 0 && discountRate <= 1)
            this.discountRate = discountRate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isAvailable(Date date) {
        return date.after(startDate) && date.before(endDate);
    }

    @Override
    public String toString() {
        return offerId + "," + title + "," + discountRate + ","
                + startDate + "," + endDate;
    }
}

