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

        final EditText departField = (EditText) findViewById(R.id.depart_field);
        final EditText destinationField = (EditText) findViewById(R.id.destination_field);
        final EditText dateField = (EditText) findViewById(R.id.date_field);
        Button buttonSearch = (Button) findViewById(R.id.button_search);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textDepart = departField.getText().toString();
                String textDestination = destinationField.getText().toString();
                String textDate = dateField.getText().toString();

                if (textDepart.isEmpty() || textDestination.isEmpty()) {
                    Toast.makeText(SearchItineraryActivity.this, getResources().getString(R.string.form_error), Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(SearchItineraryActivity.this, ListResultsActivity.class);
                    SearchRequestModel searchRequest =new SearchRequestModel(textDepart,textDestination, textDate);
                    intent.putExtra("searchRequest", searchRequest);
                    SearchItineraryActivity.this.startActivity(intent);
                }
            }
        });
        final Calendar calendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view,int year,int month,int dayOfMonth){
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            UpdateLabel(dateField, calendar);
        }
        };
        dateField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SearchItineraryActivity.this, dateListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),  calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void UpdateLabel(EditText dateField, Calendar myCalendar) {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
        dateField.setText(sdf.format(myCalendar.getTime()));
    }

}
