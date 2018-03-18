package fr.wcs.blablacrade;

import java.util.Date;

public class TripResultModel {
    private String firstname;
    private Date date;
    private int price;

    public TripResultModel(String firstname, Date date, int price) {
        this.firstname = firstname;
        this.date = date;
        this.price = price;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getFirstname() {
        return firstname;
    }
    public Date getDate() {
        return date;
    }
    public int getPrice() {
        return price;
    }

}
