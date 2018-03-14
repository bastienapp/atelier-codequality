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

        /** On récupère les données envoyées depuis SearchItinerary */

        SearchRequestModel searchRequestModel = getIntent().getParcelableExtra("searchRequest");
        String strDeparture = searchRequestModel.getDeparture();
        String strDestination = searchRequestModel.getDestination();
        String strDate = searchRequestModel.getDate();

        Toast.makeText(this, strDate, Toast.LENGTH_LONG).show();

        setTitle(strDeparture + " >> " + strDestination);

        ListView listView = (ListView) findViewById(R.id.listViewSearchResults);
        ArrayList<TripResultModel> tripResult = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");


        try {
            tripResult.add(new TripResultModel("Bernard", sdf.parse("21/02/2017-15:30"), 15));
            tripResult.add(new TripResultModel("Jean-Jacques", sdf.parse("21/02/2017-16:00"), 20));
            tripResult.add(new TripResultModel("Bertrand", sdf.parse("21/02/2017-16:30"), 16));
            tripResult.add(new TripResultModel("Gertrude", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {
        }

        TripResultAdapter adapter = new TripResultAdapter(this, tripResult);
        listView.setAdapter(adapter);
    }
}
