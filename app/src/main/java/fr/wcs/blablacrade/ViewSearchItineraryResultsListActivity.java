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

        SearchRequestModel searchRequest = getIntent().getParcelableExtra("searchRequest");
        String departure = searchRequest.getDeparture();
        String destination = searchRequest.getDestination();
        String date = searchRequest.getDate();

        Toast.makeText(this, date, Toast.LENGTH_LONG).show();

        setTitle(departure + " >> " + destination);

        ListView results = (ListView) findViewById(R.id.listViewSearchResults);
        ArrayList<TripResultModel> resultModels = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        try {
                        resultModels.add(new TripResultModel("Bernard", 15, sdf.parse("21/02/2017-15:30")));
                        resultModels.add(new TripResultModel("Jean-Jacques", 20, sdf.parse("21/02/2017-16:00")));
                        resultModels.add(new TripResultModel("Bertrand", 16, sdf.parse("21/02/2017-16:30")));
                        resultModels.add(new TripResultModel("Gertrude", 40, sdf.parse("21/02/2017-17:00")));
            }

        catch (ParseException e) {

        }

        TripResultAdapter resultAdapter = new TripResultAdapter(this, resultModels);results.setAdapter(resultAdapter);
    }
}
