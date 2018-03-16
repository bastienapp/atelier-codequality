package fr.wcs.blablacrade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SearchItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        SearchRequestModel results = getIntent().getParcelableExtra("searchRequest");
        String departureString = results.getDeparture();
        String destinationString = results.getDestination();
        String dateString = results.getDate();

        Toast.makeText(this, dateString, Toast.LENGTH_LONG).show();

        setTitle(departureString + " >> " + destinationString);

        ListView listView = (ListView) findViewById(R.id.listViewSearchResults);
        ArrayList<TripResultModel> arrayResults = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
        try {
            arrayResults.add(new TripResultModel("Bernard", sdf.parse("21/02/2017-15:30"), 15));
            arrayResults.add(new TripResultModel("Jean-Jacques", sdf.parse("21/02/2017-16:00"), 20));
            arrayResults.add(new TripResultModel("Bertrand", sdf.parse("21/02/2017-16:30"), 16));
            arrayResults.add(new TripResultModel("Gertrude", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {
        }
        TripResultAdapter adapter = new TripResultAdapter(this, arrayResults);
        listView.setAdapter(adapter);
    }
}
