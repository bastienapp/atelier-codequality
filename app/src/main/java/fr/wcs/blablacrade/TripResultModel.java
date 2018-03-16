package fr.wcs.blablacrade;

import java.util.Date;

/**
 * Created by wilder on 13/09/17.
 */

public class TripResultModel {

    public Date getDepare() {
        return depare;
    }

    public int getPrice() {
        return price;
    }

    private String prénom;
    private int price;

    public TripResultModel(String prénom, Date depare, int price) {
        this.prénom = prénom;this.depare = depare;this.price = price;
    }

    private Date depare;

    public String getPrénom() {return prénom;}
}
