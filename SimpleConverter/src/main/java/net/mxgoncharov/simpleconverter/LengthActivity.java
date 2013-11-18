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
                switch (position){
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
                    case 7:
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
                    final double[] cm = new double[1];
                    final double[] ft = new double[1];
                    final double[] in = new double[1];
                    final double[] km = new double[1];
                    final double[] m = new double[1];
                    final double[] min = new double[1];
                    final double[] mile = new double[1];
                    final double[] mm = new double[1];

                    switch (spinnerSelectedPos){
                        case 0:
                                    cm[0] = inputDouble;    //This value is selected
                                    ft[0] = inputDouble * 0.032808399;
                                    in[0] = inputDouble * 0.393700787;
                                    km[0] = inputDouble * 0.00001;
                                    m[0] = inputDouble * 0.001;
                                    min[0] = inputDouble * 393700.787;
                                    mile[0] = inputDouble * 0.0000062137;
                                    mm[0] = inputDouble * 10;
                            break;
                        case 1:
                                    cm[0] = inputDouble * 30.48;
                                    ft[0] = inputDouble;    //This value is selected
                                    in[0] = inputDouble * 12;
                                    km[0] = inputDouble * 0.0003048;
                                    m[0] = inputDouble * 0.3048;
                                    min[0] = inputDouble * 12000000;
                                    mile[0] = inputDouble * 0.000189393939;
                                    mm[0] = inputDouble * 304.8;
                            break;
                        case 2:
                                    cm[0] = inputDouble * 2.54;
                                    ft[0] = inputDouble * 0.0833333333;
                                    in[0] = inputDouble;    //This value is selected
                                    km[0] = inputDouble * 0.000025400;
                                    m[0] = inputDouble * 0.0254;
                                    min[0] = inputDouble * 1000000;
                                    mile[0] = inputDouble * 0.0000157828;
                                    mm[0] = inputDouble * 25.4;
                            break;
                        case 3:
                                    cm[0] = inputDouble * 100000;
                                    ft[0] = inputDouble * 3280.8399;
                                    in[0] = inputDouble * 39370.0787;
                                    km[0] = inputDouble;   //This value is selected
                                    m[0] = inputDouble * 1000;
                                    min[0] = inputDouble * 39370078740.0;
                                    mile[0] = inputDouble * 0.621371192;
                                    mm[0] = inputDouble * 1000000;
                            break;
                        case 4:
                                    cm[0] = inputDouble * 100;
                                    ft[0] = inputDouble * 3.2808399;
                                    in[0] = inputDouble * 39.3700787;
                                    km[0] = inputDouble * 0.001;
                                    m[0] = inputDouble;  //This value is selected
                                    min[0] = inputDouble * 39370078.74;
                                    mile[0] = inputDouble * 0.000621371192;
                                    mm[0] = inputDouble * 1000;
                            break;
                        case 5:
                                    cm[0] = inputDouble * 0.0000025400;
                                    ft[0] = inputDouble * 0.00000008;
                                    in[0] = inputDouble * 0.0000010000;
                                    km[0] = inputDouble * 0.025400000;
                                    m[0] = inputDouble * 0.0000000254;
                                    min[0] = inputDouble;   //This value is selected
                                    mile[0] = inputDouble * 0.00000000001578282828;
                                    mm[0] = inputDouble * 0.000025400;
                            break;
                        case 6:
                                    cm[0] = inputDouble * 160934.4;
                                    ft[0] = inputDouble * 5280;
                                    in[0] = inputDouble * 63360;
                                    km[0] = inputDouble * 1.609344;
                                    m[0] = inputDouble * 1609.344;
                                    min[0] = inputDouble * 63360000000.0;
                                    mile[0] = inputDouble; //This value is selected
                                    mm[0] = inputDouble * 0.000025400;
                            break;
                        case 7:
                                    cm[0] = inputDouble * 0.1;
                                    ft[0] = inputDouble * 0.0032808399;
                                    in[0] = inputDouble * 0.0393700787;
                                    km[0] = inputDouble * 0.0000010000;
                                    m[0] = inputDouble * 0.001;
                                    min[0] = inputDouble * 39370;
                                    mile[0] = inputDouble * 0.000000621371;
                                    mm[0] = inputDouble; //This value is selected
                            break;
                    }

                    resultCM.setText(String.valueOf(cm[0]));
                    resultFT.setText(String.valueOf(ft[0]));
                    resultIN.setText(String.valueOf(in[0]));
                    resultKM.setText(String.valueOf(km[0]));
                    resultM.setText(String.valueOf(m[0]));
                    resultMIN.setText(String.valueOf(min[0]));
                    resultMile.setText(String.valueOf(mile[0]));
                    resultMM.setText(String.valueOf(mm[0]));
                }
                else {
                    Toast.makeText(LengthActivity.this, "Input field is empty. Type something to convert.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
