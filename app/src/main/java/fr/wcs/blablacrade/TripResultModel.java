package fr.wcs.blablacrade;

import java.util.Date;


public class TripResultModel {

    private Date departure;
    private String firstname;
    private int price;

    public TripResultModel(String firstname, Date departure, int price) {
        this.firstname = firstname;
        this.departure = departure;
        this.price = price;
    }

    public Date getDeparture() {
        return departure;
    }

    public int getPrice() {
        return price;
    }

    public String getFirstname() {
        return firstname;
    }
}
