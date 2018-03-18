package fr.wcs.blablacrade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ListResultsActivity extends AppCompatActivity {

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

        ListView listView = (ListView) findViewById(R.id.listview_search_results);

        ArrayList<TripResultModel> table = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
        try {
            table.add(new TripResultModel("Bernard", sdf.parse("21/02/2017-15:30"), 15));
            table.add(new TripResultModel("Jean-Jacques", sdf.parse("21/02/2017-16:00"), 20));
            table.add(new TripResultModel("Bertrand", sdf.parse("21/02/2017-16:30"), 16));
            table.add(new TripResultModel("Gertrude", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {
        }

        TripResultAdapter adapter = new TripResultAdapter(this, table);
        listView.setAdapter(adapter);
    }
}
