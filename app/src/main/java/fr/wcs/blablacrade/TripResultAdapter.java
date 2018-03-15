package fr.wcs.blablacrade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wilder on 13/09/17.
 */

public class TripResultAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<TripResultModel> items;

    public TripResultAdapter(Context context, ArrayList<TripResultModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
            inflate(R.layout.trip_item, parent, false);
        }

        // get current item to be displayed
        TripResultModel currentItem = (TripResultModel) getItem(position);

        // get the TextView for item name and item description
        TextView mTripDeparture = (TextView) convertView.findViewById(R.id.text_trip_departure);
        TextView mFirstname = (TextView) convertView.findViewById(R.id.text_firstname);
        TextView mPrice = (TextView) convertView.findViewById(R.id.text_trip_price);

        //sets the text for item name and item description from the current item object
        mTripDeparture.setText(currentItem.getTripDeparture().toString());
        mFirstname.setText(currentItem.getFirstname());
        mPrice.setText(String.valueOf(currentItem.getPrice()));

        // returns the view for the current row
        return convertView;
    }
}