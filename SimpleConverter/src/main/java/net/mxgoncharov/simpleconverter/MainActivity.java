package net.mxgoncharov.simpleconverter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        boolean checkfirstrun = getSharedPreferences

                ("PREFERENCE", MODE_PRIVATE).getBoolean("checkfirstrun", true);

        getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .edit()
                .putBoolean("checkfirstrun", false)
                .commit();

        if (checkfirstrun){

            new AlertDialog.Builder(this)

                    .setTitle("Hello World!")
                    .setMessage("Thanks for downloading my app")

                    .setNeutralButton("Okay", null).show();

        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mainListView = (ListView)findViewById(R.id.listView);


        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent lengthIntent = new Intent(MainActivity.this, LengthActivity.class);
                        startActivity(lengthIntent);
                        break;
                    case 1:
                        Intent weightIntent = new Intent(MainActivity.this, WeightActivity.class);
                        startActivity(weightIntent);
                        break;
                    case 2:
                        Intent temperatureIntent = new Intent(MainActivity.this, TemperatureActivity.class);
                        startActivity(temperatureIntent);
                        break;
                    case 3:
                        Intent memoryIntent = new Intent(MainActivity.this, MemoryActivity.class);
                        startActivity(memoryIntent);
                        break;
                    case 4:
                        Intent aboutIntent = new Intent(MainActivity.this, About.class);
                        startActivity(aboutIntent);
                        break;
                }
            }
        });
    }
}
