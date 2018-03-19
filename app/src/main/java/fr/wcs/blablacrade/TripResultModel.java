package fr.wcs.blablacrade;

import java.util.Date;


public class TripResultModel {

    private Date date;
    private String firstname;
    private int price;

    public TripResultModel(String firstname, Date date, int price) {
        this.firstname = firstname;
        this.date = date;
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

    public String getFirstname() {
        return firstname;
    }

}
