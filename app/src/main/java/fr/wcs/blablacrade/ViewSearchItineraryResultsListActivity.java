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

        SearchRequestModel search = getIntent().getParcelableExtra("searchRequest");
        String departure = search.getDeparture();
        String destination = search.getDestination();
        String departureDate = search.getDepartureDate();

        Toast.makeText(this, departureDate, Toast.LENGTH_LONG).show();

        setTitle(departure + " >> " + destination);

        // TODO : add result to array adapter
        ListView result = (ListView) findViewById(R.id.listViewSearchResults);
        ArrayList<TripResultModel> tableau = new ArrayList<>();SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
        try {
            tableau.add(new TripResultModel("Bernard", sdf.parse("21/02/2017-15:30"), 15));
            tableau.add(new TripResultModel("Jean-Jacques", sdf.parse("21/02/2017-16:00"), 20));
            tableau.add(new TripResultModel("Bertrand", sdf.parse("21/02/2017-16:30"), 16));
            tableau.add(new TripResultModel("Gertrude", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {
        }
        TripResultAdapter adapteur = new TripResultAdapter(this, tableau);result.setAdapter(adapteur);
    }
}
