package fr.wcs.blablacrade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TripResultAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<TripResultModel> items;

    public TripResultAdapter(Context context, ArrayList<TripResultModel> items) {
        this.context = context;
        this.items = items;
    }

        @Override
        public int getCount() {
            return items.size(); //returns total of items in the list
    }

        @Override
        public Object getItem(int position) {
            return items.get(position); //returns list item at the specified position
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
        TripResultModel currentItem = (TripResultModel) getItem(position);
        TextView textDeparture = convertView.findViewById(R.id.text_view_departure);
        TextView textFirstname = convertView.findViewById(R.id.text_view_firstname);
        TextView textPrice = convertView.findViewById(R.id.text_view_price);

        textDeparture.setText(currentItem.getDate().toString());
        textFirstname.setText(currentItem.getName());
        textPrice.setText(String.valueOf(currentItem.getPrice()));
        return convertView;
    }
}