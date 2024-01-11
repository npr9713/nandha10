package com.example.cmrlproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class storejehome extends AppCompatActivity {
    ImageButton b1,b2,b3;
    String faulty_type,selected_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storejehome);

        b2=findViewById(R.id.dashboardbut);
        b3=findViewById(R.id.profilebut);
        Spinner faulttypeSpinner=findViewById(R.id.fault_type_Spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spare_request_type_codes, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        faulttypeSpinner.setAdapter(adapter);
        faulttypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item from the spinner
                faulty_type = parent.getItemAtPosition(position).toString();
                Log.d("faulty_type",faulty_type);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String not_selected_fault = "true";
            }
        });
        Spinner statusSpinner = findViewById(R.id.statusSpinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.store_status_codes, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusSpinner.setAdapter(adapter1);

        statusSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item from the spinner
                selected_status = parent.getItemAtPosition(position).toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String not_selected_status = "true";
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storejehome.this, storejedashboard.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storejehome.this, storejeprofile.class);
                startActivity(i);
            }
        });
    }
}
