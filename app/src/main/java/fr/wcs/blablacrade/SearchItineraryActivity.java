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

public class SearchItineraryActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        final EditText editstart = (EditText) findViewById(R.id.edit_start);
        final EditText editdestination = (EditText) findViewById(R.id.edit_destination);
        final EditText editdate = (EditText) findViewById(R.id.edit_date);
        Button buttonpush = (Button) findViewById(R.id.button_push);

        // click action
        buttonpush.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String text1 = editstart.getText().toString();
                String text2 = editdestination.getText().toString();
                String texte = editdate.getText().toString();

                if (text1.isEmpty() || text2.isEmpty())
                {
                    Toast painGrillé = Toast.makeText(getApplicationContext(), getResources().getString(R.string.form_error), Toast.LENGTH_SHORT);
                    painGrillé.show();
                }
                else
                {
                    Intent intent = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
                        SearchRequestModel searchRequest=new SearchRequestModel(text1, text2, texte); intent.putExtra("searchRequest", searchRequest);

                        SearchItineraryActivity.this.startActivity(intent);
                }
            }
        });

        final Calendar calendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener()
        {

            @Override
            public void onDateSet(DatePicker view,int year,int month,int day)
            {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            UpdateLabel(editdate, calendar);
            }};

        editdate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
            new DatePickerDialog(SearchItineraryActivity.this,
                dateListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }

    private void UpdateLabel(EditText editText, Calendar myCalendar)
    {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
        editText.setText(sdf.format(myCalendar.getTime()));
    }
}
