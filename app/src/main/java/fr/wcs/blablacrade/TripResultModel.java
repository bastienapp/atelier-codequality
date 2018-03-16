package fr.wcs.blablacrade;

import java.util.Date;

/**
 * Created by wilder on 13/09/17.
 */

public class TripResultModel {

    private String firstname;
    private int price;
    private Date departure;

    public Date getDeparture() {

        return departure;
    }

    public int getPrice() {

        return price;
    }

    public TripResultModel(String firstname, Date departure, int price) {
        this.firstname = firstname;
        this.departure = departure;
        this.price = price;
    }

    public String getFirstname() {
        return firstname;
    }
}
