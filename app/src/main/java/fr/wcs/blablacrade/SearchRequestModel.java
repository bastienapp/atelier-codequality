package fr.wcs.blablacrade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bastienwcs on 21/09/17.
 */

public class SearchRequestModel implements Parcelable {

    private String depare;
    private String destination;
    private String date;

    public String getDepare() {
        return depare;
    }

    public String getDestination() {
        return destination;
    }

    public SearchRequestModel(String depare, String destination, String date) {
        this.depare = depare;
        this.destination = destination;
        this.date = date;
    }

        protected SearchRequestModel(Parcel in) {
            depare = in.readString();
            destination = in.readString();
            date = in.readString();
        }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(depare);
        dest.writeString(destination);
        dest.writeString(date);
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

    public String getDate() {
        return date;
    }
}
