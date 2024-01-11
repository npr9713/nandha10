package com.example.cmrlproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class reserved_spare extends AppCompatActivity {

    TextView t1;
    String fault_type;
    EditText e1;
    Button b1;
    AutoCompleteTextView unitnameAutoCompleteTextView;
    AutoCompleteTextView sparerequestedAutoCompleteTextView,requestedbyAutoCompleteTextView;
    String selectedUnitname,selectedSparereq,selectedReqby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reserved_spare);
        t1=findViewById(R.id.sparereqtype);
        e1=findViewById(R.id.editTextDate);

        b1=findViewById(R.id.submit_req);
        Intent i = getIntent();

        fault_type=i.getStringExtra("fault type");
        t1.setText(fault_type);


        unitnameAutoCompleteTextView = findViewById(R.id.unitnameAutoCompleteTextView);
        sparerequestedAutoCompleteTextView = findViewById(R.id.sparerequestedAutoCompleteTextView);
        requestedbyAutoCompleteTextView= findViewById(R.id.requestedbyAutoCompleteTextView);


        String[] UnitnameArray = getResources().getStringArray(R.array.unit_name_codes);

        ArrayAdapter<String> UnitnameAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, UnitnameArray);
        unitnameAutoCompleteTextView.setAdapter(UnitnameAdapter);

        unitnameAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedUnitname = (String) parent.getItemAtPosition(position);
                Log.d("selected location", selectedUnitname);
            }
        });
        String[] SparerequestedArray = getResources().getStringArray(R.array.SPARE_REQUESTED_codes);

        ArrayAdapter<String> SparerequestedAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, SparerequestedArray);
        sparerequestedAutoCompleteTextView.setAdapter(SparerequestedAdapter);

        sparerequestedAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedSparereq = (String) parent.getItemAtPosition(position);
                Log.d("selected location", selectedSparereq);
            }
        });
        String[] RequestedbyArray = getResources().getStringArray(R.array.requested_by_codes);

        ArrayAdapter<String> RequestedbyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, RequestedbyArray);
        requestedbyAutoCompleteTextView.setAdapter(RequestedbyAdapter);

        requestedbyAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedReqby = (String) parent.getItemAtPosition(position);
                Log.d("selected location", selectedReqby);
            }
        });


    }
}
