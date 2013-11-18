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

public class WeightActivity extends Activity {

    private int spinnerSelectedPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        //Create spinner for length with input values
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);

        //Values for length spinner
        String[] spinnerList = new String[]{"cg", "gram", "kg", "lb", "mg", "oz", "tonne"};

        //Adapter for spinner. Set items in spinner
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerList);
        spinner.setAdapter(adapter);

        //inputField for input value to converter
        final EditText inputField = (EditText)findViewById(R.id.inputField);

        //Init all result textviews for length converter
        final TextView resultCG = (TextView)findViewById(R.id.resultCGTV);
        final TextView resultG = (TextView)findViewById(R.id.resultGTV);
        final TextView resultKG = (TextView)findViewById(R.id.resultKGTV);
        final TextView resultLB = (TextView)findViewById(R.id.resultLBTV);
        final TextView resultMG = (TextView)findViewById(R.id.resultMGTV);
        final TextView resultOZ = (TextView)findViewById(R.id.resultOZTV);
        final TextView resultT = (TextView)findViewById(R.id.resultTTV);



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
                    final double[] cg = new double[1];
                    final double[] g = new double[1];
                    final double[] kg = new double[1];
                    final double[] lb = new double[1];
                    final double[] mg = new double[1];
                    final double[] oz = new double[1];
                    final double[] tonne = new double[1];

                    switch (spinnerSelectedPos){
                        case 0:
                            cg[0] = inputDouble;    //This value is selected
                            g[0] = inputDouble * 0.01;
                            kg[0] = inputDouble * 0.00001;
                            lb[0] = inputDouble * 0.000022046226218;
                            mg[0] = inputDouble * 10;
                            oz[0] = inputDouble * 0.0003527396195;
                            tonne[0] = inputDouble * 0.000000010;
                            break;
                        case 1:
                            cg[0] = inputDouble * 100;
                            g[0] = inputDouble; //This value is selected
                            kg[0] = inputDouble * 0.001;
                            lb[0] = inputDouble * 0.0022046226218;
                            mg[0] = inputDouble * 1000;
                            oz[0] = inputDouble * 0.03527396195;
                            tonne[0] = inputDouble * 0.000001;
                            break;
                        case 2:
                            cg[0] = inputDouble * 100000;
                            g[0] = inputDouble * 1000;
                            kg[0] = inputDouble;    //This value is selected
                            lb[0] = inputDouble * 2.2046226218;
                            mg[0] = inputDouble * 1000000 ;
                            oz[0] = inputDouble * 35.27396195;
                            tonne[0] = inputDouble * 0.001;
                            break;
                        case 3:
                            cg[0] = inputDouble * 45359.237;
                            g[0] = inputDouble * 453.59237;
                            kg[0] = inputDouble * 0.45359237;
                            lb[0] = inputDouble;    //This value is selected
                            mg[0] = inputDouble * 453592.37;
                            oz[0] = inputDouble * 16;
                            tonne[0] = inputDouble * 0.00045359237;
                            break;
                        case 4:
                            cg[0] = inputDouble * 0.1;
                            g[0] = inputDouble * 0.001;
                            kg[0] = inputDouble * 0.000001;
                            lb[0] = inputDouble * 0.0000022046226218;
                            mg[0] = inputDouble;    //This value is selected
                            oz[0] = inputDouble * 0.00003527396195;
                            tonne[0] = inputDouble * 1.0e-9;
                            break;
                        case 5:
                            cg[0] = inputDouble * 2834.9523125;
                            g[0] = inputDouble * 28.349523125;
                            kg[0] = inputDouble * 0.028349523125;
                            lb[0] = inputDouble * 0.0625;
                            mg[0] = inputDouble * 28349.523125;
                            oz[0] = inputDouble;    //This value is selected
                            tonne[0] = inputDouble * 0.000028349523125;
                            break;
                        case 6:
                            cg[0] = inputDouble * 100000000;
                            g[0] = inputDouble * 1000000;
                            kg[0] = inputDouble * 1000;
                            lb[0] = inputDouble * 2204.6226218;
                            mg[0] = inputDouble * 1000000000;
                            oz[0] = inputDouble * 35273.96195 ;
                            tonne[0] = inputDouble; //This value is selected
                            break;
                    }

                    resultCG.setText(String.valueOf(cg[0]));
                    resultG.setText(String.valueOf(g[0]));
                    resultKG.setText(String.valueOf(kg[0]));
                    resultLB.setText(String.valueOf(lb[0]));
                    resultMG.setText(String.valueOf(mg[0]));
                    resultOZ.setText(String.valueOf(oz[0]));
                    resultT.setText(String.valueOf(tonne[0]));

                }
                else {
                    Toast.makeText(WeightActivity.this, "Input field is empty. Type something to convert.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
