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
                switch (position) {
                    case 0:
                        spinnerSelectedPos = position;
                        break;
                    case 1:
                        spinnerSelectedPos = position;
                        break;
                    case 2:
                        spinnerSelectedPos = position;
                        break;
                    case 3:
                        spinnerSelectedPos = position;
                        break;
                    case 4:
                        spinnerSelectedPos = position;
                        break;
                    case 5:
                        spinnerSelectedPos = position;
                        break;
                    case 6:
                        spinnerSelectedPos = position;
                        break;

                }
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

                    //Vars for results
                    final double[] c = new double[1];
                    final double[] f = new double[1];
                    final double[] k = new double[1];

                    switch (spinnerSelectedPos){
                        case 0:
                            c[0] = inputDouble;    //This value is selected
                            f[0] = (inputDouble * 9 / 5) + 32;
                            k[0] = inputDouble + 273.15;
                            break;
                        case 1:
                            c[0] = (inputDouble - 32) * 5 / 9;
                            f[0] = inputDouble;  //This value is selected
                            k[0] = ((inputDouble - 32) / 1.800) + 273.15;
                            break;
                        case 2:
                            c[0] = inputDouble - 273.15;
                            f[0] = (inputDouble - 273.15) * 1.8000 + 32.00 ;
                            k[0] = inputDouble;   //This value is selected
                            break;
                    }

                    resultC.setText(String.valueOf(c[0]));
                    resultF.setText(String.valueOf(f[0]));
                    resultK.setText(String.valueOf(k[0]));
                }
                else {
                    Toast.makeText(TemperatureActivity.this, "Input field is empty. Type something to convert.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
