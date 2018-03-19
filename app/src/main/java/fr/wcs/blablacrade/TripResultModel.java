package fr.wcs.blablacrade;

import java.util.Date;

public class TripResultModel {

    private String name;
    private int price;
    private Date date;

    public TripResultModel(String name, int price, Date date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }
}

