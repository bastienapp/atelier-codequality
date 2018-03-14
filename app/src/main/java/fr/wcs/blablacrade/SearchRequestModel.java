package fr.wcs.blablacrade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bastienwcs on 21/09/17.
 */

public class SearchRequestModel implements Parcelable {

    private String departure;
    private String destination;
    private String departureDate;

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public SearchRequestModel(String departure, String destination, String departureDate) {
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
    }

    protected SearchRequestModel(Parcel in) {
        departure = in.readString();
        destination = in.readString();
        departureDate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(departure);
        dest.writeString(destination);
        dest.writeString(departureDate);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getDepartureDate() {
        return departureDate;
    }
}
