package fr.wcs.blablacrade;

import java.util.Date;

/**
 * Created by wilder on 13/09/17.
 */
// I tranlate in English all the Variables and correct the constructors structure.
public class TripResultModel {


    private String firstName;
    private int price;
    private Date departure;

    public Date getDeparture() {

        return departure;
    }

    public int getPrice() {

        return price;
    }

    public String getFirstName() {

        return firstName;
    }

    public TripResultModel(String firstName, Date departure, int price) {
        this.firstName = firstName;
        this.departure = departure;
        this.price = price;
    }


}
