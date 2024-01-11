package com.example.cmrlproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.eazegraph.lib.charts.PieChart;

public class storejedashboard extends AppCompatActivity {
    TextView tvpending, tvhandovered, tvhsf, tvclosed,tvosr;
    ImageButton b2,b3;
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storejedashboard);

        b2=findViewById(R.id.homebut);
        b3=findViewById(R.id.profilebut);
        tvpending=findViewById(R.id.tvpending);
        tvhandovered=findViewById(R.id.tvhandovered);
        tvhsf=findViewById(R.id.tvhsf);
        tvclosed=findViewById(R.id.tvclosed);
        tvosr=findViewById(R.id.tvosr);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storejedashboard.this, storejehome.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storejedashboard.this, storejeprofile.class);
                startActivity(i);
            }
        });


    }
}
