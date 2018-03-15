package fr.wcs.blablacrade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bastienwcs on 21/09/17.
 */

public class SearchRequestModel implements Parcelable
{
    private String starting;
    private String where;
    private String when;

    public String getStarting() {
        return starting;
    }
    public String getwhere() {
        return where;
    }
    public SearchRequestModel(String starting, String where, String when)
    {
        this.starting = starting;
        this.where = where;
        this.when = when;
    }

    protected SearchRequestModel(Parcel in)
    {
        starting = in.readString();
        where = in.readString();
        when = in.readString();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(starting);
        dest.writeString(where);
        dest.writeString(when);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SearchRequestModel> CREATOR = new Creator<SearchRequestModel>()
        {
            @Override
            public SearchRequestModel createFromParcel(Parcel in)
                {
                return new SearchRequestModel(in);
                }

            @Override
            public SearchRequestModel[] newArray(int size) {
                return new SearchRequestModel[size];
            }
        };

            public String getWhen() {
        return when;
    }
}
