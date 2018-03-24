package fr.wcs.blablacrade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bastienwcs on 21/09/17.
 */

public class SearchRequestModel implements Parcelable {


    private String departureModel;
    private String destinationModel;
    private String dateModel;

    //getters
    public String getDepartureModel() {
        return departureModel;
    }
    public String getDestinationModel() {
        return destinationModel;
    }
    public String getDateModel() {
        return dateModel;
    }

    public SearchRequestModel(String departureModel, String destinationModel, String dateModel) {
        this.departureModel = departureModel;
        this.destinationModel = destinationModel;
        this.dateModel = dateModel;
    }

    protected SearchRequestModel(Parcel in) {
        departureModel = in.readString();
        destinationModel = in.readString();
        dateModel = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(departureModel);
        dest.writeString(destinationModel);
        dest.writeString(dateModel);
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


}
