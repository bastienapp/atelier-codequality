package fr.wcs.blablacrade;

import java.util.Date;

/**
 * Created by wilder on 13/09/17.
 */

public class TripResultModel {

    private Date tripDeparture;
    private String firstname;
    private int price;

    public TripResultModel(String firstname, Date tripDeparture, int price) {
        this.firstname = firstname;
        this.tripDeparture = tripDeparture;
        this.price = price;
    }

    public String getFirstname() {return firstname;}

    public Date getTripDeparture() {
        return tripDeparture;
    }

    public int getPrice() {
        return price;
    }
}
