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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_trip, parent, false);
        }
        TripResultModel currentItem = (TripResultModel) getItem(position);
        TextView departure = convertView.findViewById(R.id.texteresu1);
        TextView firstname = convertView.findViewById(R.id.textres2);
        TextView price = convertView.findViewById(R.id.txt);
        departure.setText(currentItem.getDeparture().toString());
        firstname.setText(currentItem.getFirstname());
        price.setText(String.valueOf(currentItem.getPrice()));

        return convertView;
    }
}