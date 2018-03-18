package fr.wcs.blablacrade;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchRequestModel implements Parcelable {

    private String departure;
    private String destination;
    private String date;

    public SearchRequestModel(String departure, String destination, String date) {
        this.departure = departure;
        this.destination = destination;
        this.date = date;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }
    public String getDestination() {
        return destination;
    }
    public String getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return Integer.parseInt(getDeparture() + getDestination() + getDate());
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(departure);
        parcel.writeString(destination);
        parcel.writeString(date);
    }

    protected SearchRequestModel(Parcel in) {
        departure = in.readString();
        destination = in.readString();
        date = in.readString();
    }

    public static final Creator<SearchRequestModel> CREATOR = new Creator<SearchRequestModel>() {
        @Override
        public SearchRequestModel createFromParcel(Parcel in) {
            return new SearchRequestModel(in);
        }

        @Override
        public SearchRequestModel[] newArray(int size) {
            return new SearchRequestModel[size];
        }
    };


}
