package fr.wcs.blablacrade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        SearchRequestModel searchTrip = getIntent().getParcelableExtra("searchRequest");
        String departure = searchTrip.getDeparture();
        String destination = searchTrip.getDestination();
        String date = searchTrip.getDate();
        ListView searchResult = (ListView) findViewById(R.id.listViewSearchResults);
        ArrayList<TripResultModel> listTrip = new ArrayList<>();SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        Toast.makeText(this, date, Toast.LENGTH_LONG).show();
        setTitle(departure + " >> " + destination);

        try {
            listTrip.add(new TripResultModel("Bernard", sdf.parse("21/02/2017-15:30"), 15));
            listTrip.add(new TripResultModel("Jean-Jacques", sdf.parse("21/02/2017-16:00"), 20));
            listTrip.add(new TripResultModel("Bertrand", sdf.parse("21/02/2017-16:30"), 16));
            listTrip.add(new TripResultModel("Gertrude", sdf.parse("21/02/2017-17:00"), 40));
        }
        catch (ParseException e) {
        }

        TripResultAdapter adapter = new TripResultAdapter(this, listTrip);
        searchResult.setAdapter(adapter);
    }
}
