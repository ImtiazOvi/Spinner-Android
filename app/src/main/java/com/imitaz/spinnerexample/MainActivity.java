package com.imitaz.spinnerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinnerArrayList);
        ArrayList<String> countryList = new ArrayList();
        countryList.add("Select country...");
        countryList.add("Bangladesh");
        countryList.add("UK");
        countryList.add("USA");
        countryList.add("Germany");
        countryList.add("Rasia");
        countryList.add("Canada");
        countryList.add("Spain");

        //style populate the spinner
        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countryList);

        // dropdown layout style ... you can make it custome here i used default
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        // Initializing an ArrayAdapter
//
//        @Override
//        public boolean isEnabled(int position){
//            if(position == 0)
//            {
//                // Disable the first item from Spinner
//                // First item will be use for hint
//                return false;
//            }
//            else
//            {
//                return true;
//            }


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Select country...")) {
                    // don nothing
                    return;
                } else {
                    // on selected spinner item
                    String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(MainActivity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
