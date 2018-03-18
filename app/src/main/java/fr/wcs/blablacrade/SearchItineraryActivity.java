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




        // Here, I translate the Variables in English and I change the Indentation.

        final EditText editDepartureValue = (EditText) findViewById(R.id.edit_departure);
        final EditText editDestinationValue = (EditText) findViewById(R.id.edit_destination);
        final EditText editDateValue = (EditText) findViewById(R.id.edit_date);
        Button buttonSearch = (Button) findViewById(R.id.button_search);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textDepartureValue   = editDepartureValue.getText().toString();
                String textDestinationValue = editDestinationValue.getText().toString();
                String textDateValue        = editDateValue.getText().toString();

                if (textDepartureValue.isEmpty() || textDestinationValue.isEmpty()) {
                    Toast breadGrilled = Toast.makeText(getApplicationContext(),
                                getResources().getString(R.string.form_error), Toast.LENGTH_SHORT);
                                     breadGrilled.show();
                }else {
                    Intent intent = new Intent(SearchItineraryActivity.this,
                            ViewSearchItineraryResultsListActivity.class);
                    SearchRequestModel searchRequest=new SearchRequestModel(textDepartureValue, textDestinationValue, textDateValue);
                    intent.putExtra("searchRequest", searchRequest);
                    SearchItineraryActivity.this.startActivity(intent);
                }
            }
        });



        final Calendar calandar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view,int year,int month,int day){

                        calandar.set(Calendar.YEAR, year);
                        calandar.set(Calendar.MONTH, month);
                        calandar.set(Calendar.DAY_OF_MONTH, day);
                        UpdateLabel(editDateValue, calandar);
            }

            private void UpdateLabel(EditText editDateValue, Calendar calendar) {
                String myFormat = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
                editDateValue.setText(sdf.format(calendar.getTime()));
            }


        };

        editDateValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SearchItineraryActivity.this,dateListener,
                        calandar.get(Calendar.YEAR),
                        calandar.get(Calendar.MONTH),
                        calandar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


    }
 }
