package fr.wcs.blablacrade;

import java.util.Date;

/**
 * Created by wilder on 13/09/17.
 */

public class TripResultModel {
    private String firstname;
    private int price;
    private Date dateDeparture;

    public Date getdateDeparture() {
        return dateDeparture;
    }

    public int getPrice() {
        return price;
    }
    public String getFirstname() {
        return firstname;
    }


    public TripResultModel(String firstname, Date dateDeparture, int price) {
        this.firstname = firstname;
        this.dateDeparture = dateDeparture;
        this.price = price;
    }



}
