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
                    final double[] bit = new double[1];
                    final double[] b = new double[1];
                    final double[] kb = new double[1];
                    final double[] mb = new double[1];
                    final double[] gb = new double[1];
                    final double[] tb = new double[1];
                    final double[] pb = new double[1];

                    switch (spinnerSelectedPos){
                        case 0:
                            bit[0] = inputDouble;   //This value is selected
                            b[0] = inputDouble * 0.125;
                            kb[0] = inputDouble * 0.0001220703125;
                            mb[0] = inputDouble * 1.1920928955e-7;
                            gb[0] = inputDouble * 1.1641532183e-10;
                            tb[0] = inputDouble * 1.1368683772e-13;
                            pb[0] = inputDouble * 1.1102230247e-16;
                            break;
                        case 1:
                            bit[0] = inputDouble * 8;
                            b[0] = inputDouble; //This value is selected
                            kb[0] = inputDouble * 0.0009765625;
                            mb[0] = inputDouble * 9.5367431641e-7;
                            gb[0] = inputDouble * 9.3132257462e-10;
                            tb[0] = inputDouble * 9.0949470175e-13;
                            pb[0] = inputDouble * 8.8817841973e-16;
                            break;
                        case 2:
                            bit[0] = inputDouble * 8192;
                            b[0] = inputDouble * 1024;
                            kb[0] = inputDouble;    //This value is selected
                            mb[0] = inputDouble * 0.0009765625;
                            gb[0] = inputDouble * 9.5367431641e-7;
                            tb[0] = inputDouble * 9.313225746e-10;
                            pb[0] = inputDouble * 9.0949470181e-13;
                            break;
                        case 3:
                            bit[0] = inputDouble * 8388608;
                            b[0] = inputDouble * 1048576;
                            kb[0] = inputDouble * 1024;
                            mb[0] = inputDouble;    //This value is selected
                            gb[0] = inputDouble * 0.0009765625;
                            tb[0] = inputDouble * 9.5367431639e-7;
                            pb[0] = inputDouble * 9.3132257465e-10;
                            break;
                        case 4:
                            bit[0] = inputDouble * 8589934592.0;
                            b[0] = inputDouble * 1073741824;
                            kb[0] = inputDouble * 1048576;
                            mb[0] = inputDouble * 1024;
                            gb[0] = inputDouble;    //This value is selected
                            tb[0] = inputDouble * 0.00097656249998;
                            pb[0] = inputDouble * 9.5367431644e-7;
                            break;
                        case 5:
                            bit[0] = inputDouble * 8796093022400.0;
                            b[0] = inputDouble * 1099511627800.0;
                            kb[0] = inputDouble * 1073741824;
                            mb[0] = inputDouble * 1048576;
                            gb[0] = inputDouble * 1024;
                            tb[0] = inputDouble;    //This value is selected
                            pb[0] = inputDouble * 0.00097656250006;
                            break;
                        case 6:
                            bit[0] = inputDouble * 9007199254400000.0;
                            b[0] = inputDouble * 1125899906800000.0;
                            kb[0] = inputDouble * 1099511627700.0;
                            mb[0] = inputDouble * 1073741824;
                            gb[0] = inputDouble * 1048576;
                            tb[0] = inputDouble * 1024;
                            pb[0] = inputDouble;    //This value is selected
                            break;
                    }

                    resultBIT.setText(String.valueOf(bit[0]));
                    resultB.setText(String.valueOf(b[0]));
                    resultKB.setText(String.valueOf(kb[0]));
                    resultMB.setText(String.valueOf(mb[0]));
                    resultGB.setText(String.valueOf(gb[0]));
                    resultTB.setText(String.valueOf(tb[0]));
                    resultPB.setText(String.valueOf(pb[0]));

                }
                else {
                    Toast.makeText(MemoryActivity.this, "Input field is empty. Type something to convert.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}
