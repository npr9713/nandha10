package com.example.cmrlproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class storel1_sparemov_req extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    ImageButton b1,b2,b3,b4;
    Button b5;
    Spinner Moved_Station_Spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storel1_sparemov_req);
        t1=findViewById(R.id.mrid);
        t2=findViewById(R.id.station);
        t3=findViewById(R.id.sparename);
        t4=findViewById(R.id.spareserno);
        b1=findViewById(R.id.sparemov);
        b2=findViewById(R.id.homebut);
        b3=findViewById(R.id.dashboardbut);
        b4=findViewById(R.id.profilebut);
        b5=findViewById(R.id.updateb);
        Moved_Station_Spinner = findViewById(R.id.Moved_Station_Spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.moved_station_codes, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Moved_Station_Spinner.setAdapter(adapter1);

        Moved_Station_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item from the spinner
                String selected_moved_station = parent.getItemAtPosition(position).toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String not_selected_status = "true";
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storel1_sparemov_req.this, storel1dashboard.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storel1_sparemov_req.this, storel1_sparemov.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storel1_sparemov_req.this, storel1profile.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storel1_sparemov_req.this, storel1home.class);
                startActivity(i);
            }
        });

    }

}
