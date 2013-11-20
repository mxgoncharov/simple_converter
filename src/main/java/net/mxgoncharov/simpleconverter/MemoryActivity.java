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

public class MemoryActivity extends Activity {

    private int spinnerSelectedPos = 0;

    //Vars for results
    double bit;
    double b;
    double kb;
    double mb;
    double gb;
    double tb;
    double pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        //Create spinner for length with input values
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);

        //Values for length spinner
        String[] spinnerList = new String[]{"BIT", "BYTE", "KB", "MB", "GB", "TB", "PB"};

        //Adapter for spinner. Set items in spinner
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerList);
        spinner.setAdapter(adapter);

        //inputField for input value to converter
        final EditText inputField = (EditText)findViewById(R.id.inputField);

        //Init all result textviews for length converter
        final TextView resultBIT = (TextView)findViewById(R.id.resultBITTV);
        final TextView resultB = (TextView)findViewById(R.id.resultBTV);
        final TextView resultKB = (TextView)findViewById(R.id.resultKBTV);
        final TextView resultMB = (TextView)findViewById(R.id.resultMBTV);
        final TextView resultGB = (TextView)findViewById(R.id.resultGBTV);
        final TextView resultTB = (TextView)findViewById(R.id.resultTBTV);
        final TextView resultPB = (TextView)findViewById(R.id.resultPBTV);



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
                            bit = inputDouble;   //This value is selected
                            b = inputDouble * 0.125;
                            kb = inputDouble * 0.0001220703125;
                            mb = inputDouble * 1.1920928955e-7;
                            gb = inputDouble * 1.1641532183e-10;
                            tb = inputDouble * 1.1368683772e-13;
                            pb = inputDouble * 1.1102230247e-16;
                            break;
                        case 1:
                            bit = inputDouble * 8;
                            b = inputDouble; //This value is selected
                            kb = inputDouble * 0.0009765625;
                            mb = inputDouble * 9.5367431641e-7;
                            gb = inputDouble * 9.3132257462e-10;
                            tb = inputDouble * 9.0949470175e-13;
                            pb = inputDouble * 8.8817841973e-16;
                            break;
                        case 2:
                            bit = inputDouble * 8192;
                            b = inputDouble * 1024;
                            kb = inputDouble;    //This value is selected
                            mb = inputDouble * 0.0009765625;
                            gb = inputDouble * 9.5367431641e-7;
                            tb = inputDouble * 9.313225746e-10;
                            pb = inputDouble * 9.0949470181e-13;
                            break;
                        case 3:
                            bit = inputDouble * 8388608;
                            b = inputDouble * 1048576;
                            kb = inputDouble * 1024;
                            mb = inputDouble;    //This value is selected
                            gb = inputDouble * 0.0009765625;
                            tb = inputDouble * 9.5367431639e-7;
                            pb = inputDouble * 9.3132257465e-10;
                            break;
                        case 4:
                            bit = inputDouble * 8589934592.0;
                            b = inputDouble * 1073741824;
                            kb = inputDouble * 1048576;
                            mb = inputDouble * 1024;
                            gb = inputDouble;    //This value is selected
                            tb = inputDouble * 0.00097656249998;
                            pb = inputDouble * 9.5367431644e-7;
                            break;
                        case 5:
                            bit = inputDouble * 8796093022400.0;
                            b = inputDouble * 1099511627800.0;
                            kb = inputDouble * 1073741824;
                            mb = inputDouble * 1048576;
                            gb = inputDouble * 1024;
                            tb = inputDouble;    //This value is selected
                            pb = inputDouble * 0.00097656250006;
                            break;
                        case 6:
                            bit = inputDouble * 9007199254400000.0;
                            b = inputDouble * 1125899906800000.0;
                            kb = inputDouble * 1099511627700.0;
                            mb = inputDouble * 1073741824;
                            gb = inputDouble * 1048576;
                            tb = inputDouble * 1024;
                            pb = inputDouble;    //This value is selected
                            break;
                    }

                    resultBIT.setText(String.valueOf(bit));
                    resultB.setText(String.valueOf(b));
                    resultKB.setText(String.valueOf(kb));
                    resultMB.setText(String.valueOf(mb));
                    resultGB.setText(String.valueOf(gb));
                    resultTB.setText(String.valueOf(tb));
                    resultPB.setText(String.valueOf(pb));

                }
                else {
                    Toast.makeText(MemoryActivity.this, "Input field is empty. Type something to convert.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}
