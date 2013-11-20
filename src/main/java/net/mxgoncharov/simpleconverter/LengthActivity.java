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

public class LengthActivity extends Activity {

    private int spinnerSelectedPos = 0;

    double cm;
    double ft;
    double in;
    double km;
    double m;
    double min;
    double mile;
    double mm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        //Create spinner for length with input values
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);

        //Values for length spinner
        String[] spinnerList = new String[]{"cm", "ft", "in", "km", "m", "min", "M", "mm"};

        //Adapter for spinner. Set items in spinner
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerList);
        spinner.setAdapter(adapter);

        //inputField for input value to converter
        final EditText inputField = (EditText)findViewById(R.id.inputField);

        //Init all result textviews for length converter
        final TextView resultCM = (TextView)findViewById(R.id.resultCMTV);
        final TextView resultFT = (TextView)findViewById(R.id.resultFTTV);
        final TextView resultIN = (TextView)findViewById(R.id.resultITV);
        final TextView resultKM = (TextView)findViewById(R.id.resultKMTV);
        final TextView resultM = (TextView)findViewById(R.id.resultMTV);
        final TextView resultMIN = (TextView)findViewById(R.id.resultMITV);
        final TextView resultMile = (TextView)findViewById(R.id.resultMileTV);
        final TextView resultMM = (TextView)findViewById(R.id.resultMMTV);


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
                            cm = inputDouble;    //This value is selected
                            ft = inputDouble * 0.032808399;
                            in = inputDouble * 0.393700787;
                            km = inputDouble * 0.00001;
                            m = inputDouble * 0.001;
                            min = inputDouble * 393700.787;
                            mile = inputDouble * 0.0000062137;
                            mm = inputDouble * 10;
                            break;
                        case 1:
                            cm = inputDouble * 30.48;
                            ft = inputDouble;    //This value is selected
                            in = inputDouble * 12;
                            km = inputDouble * 0.0003048;
                            m = inputDouble * 0.3048;
                            min = inputDouble * 12000000;
                            mile = inputDouble * 0.000189393939;
                            mm = inputDouble * 304.8;
                            break;
                        case 2:
                            cm = inputDouble * 2.54;
                            ft = inputDouble * 0.0833333333;
                            in = inputDouble;    //This value is selected
                            km = inputDouble * 0.000025400;
                            m = inputDouble * 0.0254;
                            min = inputDouble * 1000000;
                            mile = inputDouble * 0.0000157828;
                            mm = inputDouble * 25.4;
                            break;
                        case 3:
                            cm = inputDouble * 100000;
                            ft = inputDouble * 3280.8399;
                            in = inputDouble * 39370.0787;
                            km = inputDouble;   //This value is selected
                            m = inputDouble * 1000;
                            min = inputDouble * 39370078740.0;
                            mile = inputDouble * 0.621371192;
                            mm = inputDouble * 1000000;
                            break;
                        case 4:
                            cm = inputDouble * 100;
                            ft = inputDouble * 3.2808399;
                            in = inputDouble * 3900787;
                            km = inputDouble * 0.001;
                            m = inputDouble;  //This value is selected
                            min = inputDouble * 39370078.74;
                            mile = inputDouble * 0.000621371192;
                            mm = inputDouble * 1000;
                            break;
                        case 5:
                            cm = inputDouble * 0.0000025400;
                            ft = inputDouble * 0.00000008;
                            in = inputDouble * 0.0000010000;
                            km = inputDouble * 0.025400000;
                            m = inputDouble * 0.0000000254;
                            min = inputDouble;   //This value is selected
                            mile = inputDouble * 0.00000000001578282828;
                            mm = inputDouble * 0.000025400;
                            break;
                        case 6:
                            cm = inputDouble * 160934.4;
                            ft = inputDouble * 5280;
                            in = inputDouble * 63360;
                            km = inputDouble * 1.609344;
                            m = inputDouble * 1609.344;
                            min = inputDouble * 63360000000.0;
                            mile = inputDouble; //This value is selected
                            mm = inputDouble * 0.000025400;
                            break;
                        case 7:
                            cm = inputDouble * 0.1;
                            ft = inputDouble * 0.0032808399;
                            in = inputDouble * 0.0393700787;
                            km = inputDouble * 0.0000010000;
                            m = inputDouble * 0.001;
                            min = inputDouble * 39370;
                            mile = inputDouble * 0.000000621371;
                            mm = inputDouble; //This value is selected
                            break;
                    }

                    resultCM.setText(String.valueOf(cm));
                    resultFT.setText(String.valueOf(ft));
                    resultIN.setText(String.valueOf(in));
                    resultKM.setText(String.valueOf(km));
                    resultM.setText(String.valueOf(m));
                    resultMIN.setText(String.valueOf(min));
                    resultMile.setText(String.valueOf(mile));
                    resultMM.setText(String.valueOf(mm));
                }
                else {
                    Toast.makeText(LengthActivity.this, "Input field is empty. Type something to convert.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
