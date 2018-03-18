package fr.wcs.blablacrade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TripResultAdapter extends ArrayAdapter<TripResultModel> {

    public TripResultAdapter(Context context, ArrayList<TripResultModel> trips) {
        super(context, 0, trips);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TripResultModel trip = (TripResultModel) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.trip_item, parent, false);
        }

        TextView date = (TextView) convertView.findViewById(R.id.item_text_date);
        TextView firstname = (TextView) convertView.findViewById(R.id.item_text_firstname);
        TextView price = (TextView) convertView.findViewById(R.id.item_text_price);

        date.setText(trip.getDate().toString());
        firstname.setText(trip.getFirstname().toString());
        price.setText(String.valueOf(trip.getPrice()) + " $");

        //Create new SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String dateformat = sdf.format(trip.getDate());
        String dateValue = dateformat + " PM";
        date.setText(dateValue);

        return convertView;
    }
}