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

public class handovered_spare_faulty extends AppCompatActivity {

    TextView t1;
    String fault_type;
    EditText e1,e2,e3;
    Button b1;
    AutoCompleteTextView stationAutoCompleteTextView,slenameAutoCompleteTextView,slenoAutoCompleteTextView,unitnameAutoCompleteTextView;
    AutoCompleteTextView sparerequestedAutoCompleteTextView,requestedbyAutoCompleteTextView;
    String selectedStation,selectedSLEname,selectedSLEno,selectedUnitname,selectedSparereq,selectedReqby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handovered_spare_faulty);
        t1=findViewById(R.id.sparereqtype);
        e1=findViewById(R.id.editTextDate);
        e2=findViewById(R.id.faulty_spare_SL_no);
        e3=findViewById(R.id.fault_desc);
        b1=findViewById(R.id.submit_req);
        Intent i = getIntent();

        fault_type=i.getStringExtra("fault type");
        t1.setText(fault_type);

        stationAutoCompleteTextView = findViewById(R.id.stationAutoCompleteTextView);
        slenameAutoCompleteTextView = findViewById(R.id.slenameAutoCompleteTextView);
        slenoAutoCompleteTextView = findViewById(R.id.slenoAutoCompleteTextView);
        unitnameAutoCompleteTextView = findViewById(R.id.unitnameAutoCompleteTextView);
        sparerequestedAutoCompleteTextView = findViewById(R.id.sparerequestedAutoCompleteTextView);
        requestedbyAutoCompleteTextView= findViewById(R.id.requestedbyAutoCompleteTextView);

        // Replace R.array.station_codes with the array of station names
        String[] stationArray = getResources().getStringArray(R.array.station_codes);

        ArrayAdapter<String> stationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, stationArray);
        stationAutoCompleteTextView.setAdapter(stationAdapter);

        stationAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedStation = (String) parent.getItemAtPosition(position);
                Log.d("selected location", selectedStation);
            }
        });
        String[] SLEnameArray = getResources().getStringArray(R.array.SLE_name_codes);

        ArrayAdapter<String> SLEnameAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, SLEnameArray);
        slenameAutoCompleteTextView.setAdapter(SLEnameAdapter);

        slenameAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedSLEname = (String) parent.getItemAtPosition(position);
                Log.d("selected location", selectedSLEname);
            }
        });
        String[] SLEnoArray = getResources().getStringArray(R.array.SLE_no_codes);

        ArrayAdapter<String> SLEnoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, SLEnoArray);
        slenoAutoCompleteTextView.setAdapter(SLEnoAdapter);

        slenoAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedSLEno = (String) parent.getItemAtPosition(position);
                Log.d("selected location", selectedSLEno);
            }
        });
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
