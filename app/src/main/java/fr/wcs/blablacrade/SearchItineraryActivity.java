package fr.wcs.blablacrade;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SearchItineraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        final EditText departure = (EditText) findViewById(R.id.editText1);
        final EditText arrival = (EditText) findViewById(R.id.editText2);
        final EditText departureDate = (EditText) findViewById(R.id.editText3);
        Button buttonSearch = (Button) findViewById(R.id.push);


        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String departureTxt = departure.getText().toString();
                String arrivalTxt = arrival.getText().toString();
                String departureDateTxt = departureDate.getText().toString();

                if (departureTxt.isEmpty() || arrivalTxt.isEmpty()
                        ) {
                    Toast unfilledFields = Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.form_error), Toast.LENGTH_SHORT);
                    unfilledFields.show();
                }else {Intent intent = new Intent(SearchItineraryActivity.this,
                        ViewSearchItineraryResultsListActivity.class);
                    SearchRequestModel searchRequest=new SearchRequestModel(departureTxt,
                            arrivalTxt, departureDateTxt);
                    intent.putExtra("searchRequest", searchRequest);

                    SearchItineraryActivity.this.startActivity(intent);
                }
            }
        });

        final Calendar calendarDeparture = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view,int year,int monthOfYear,int dayOfMonth){
                calendarDeparture.set(Calendar.YEAR, year);
                calendarDeparture.set(Calendar.MONTH, monthOfYear);
                calendarDeparture.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                UpdateLabel(departureDate, calendarDeparture);
            }};

        departureDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SearchItineraryActivity.this,
                        dateListener,
                        calendarDeparture.get(Calendar.YEAR),
                        calendarDeparture.get(Calendar.MONTH),
                        calendarDeparture.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }

    private void UpdateLabel(EditText editText, Calendar myCalendar) {
        String myFormat = "dd/MM/yyyy";


        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        editText.setText(sdf.format(myCalendar.getTime()));
    }
}
