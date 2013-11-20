package net.mxgoncharov.simpleconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TemperatureActivity extends Activity {

    private int spinnerSelectedPos = 0;

    //Vars for results
    double c;
    double f;
    double k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        //Create spinner for length with input values
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);

        //Values for length spinner
        String[] spinnerList = new String[]{"C", "F", "K"};

        //Adapter for spinner. Set items in spinner
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerList);
        spinner.setAdapter(adapter);

        //inputField for input value to converter
        final EditText inputField = (EditText)findViewById(R.id.inputField);

        //Init all result textviews for length converter
        final TextView resultC = (TextView)findViewById(R.id.resultCTV);
        final TextView resultF = (TextView)findViewById(R.id.resultFTV);
        final TextView resultK = (TextView)findViewById(R.id.resultKTV);




        //Init button for start convert
        Button convertButton = (Button)findViewById(R.id.convertButton);

        //Spinner selected item listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerSelectedPos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Convert button onClick listener
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputString = inputField.getText().toString();

                if(!inputString.isEmpty() && inputString != null){

                    final double inputDouble = Double.parseDouble(inputString);

                    switch (spinnerSelectedPos){
                        case 0:
                            c = inputDouble;    //This value is selected
                            f = (inputDouble * 9 / 5) + 32;
                            k = inputDouble + 273.15;
                            break;
                        case 1:
                            c = (inputDouble - 32) * 5 / 9;
                            f = inputDouble;  //This value is selected
                            k = ((inputDouble - 32) / 1.800) + 273.15;
                            break;
                        case 2:
                            c = inputDouble - 273.15;
                            f = (inputDouble - 273.15) * 1.8000 + 32.00 ;
                            k = inputDouble;   //This value is selected
                            break;
                    }

                    resultC.setText(String.valueOf(c));
                    resultF.setText(String.valueOf(f));
                    resultK.setText(String.valueOf(k));
                }
                else {
                    Toast.makeText(TemperatureActivity.this, "Input field is empty. Type something to convert.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
