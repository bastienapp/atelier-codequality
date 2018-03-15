package fr.wcs.blablacrade;

import java.util.Date;

/**
 * Created by wilder on 13/09/17.
 */

public class TripResultModel
{

    public Date getDeparture() {
        return departure;
    }

    public int getPrice() {
        return price;
    }
    private String firstname;
    private int price;

    public TripResultModel(String prénom, Date depare, int price)
    {
        this.firstname = prénom;this.departure = depare;this.price = price;
    }
    private Date departure;

    public String getFirstname() {return firstname;}
}
