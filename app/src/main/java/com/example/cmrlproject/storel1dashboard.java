package com.example.cmrlproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.eazegraph.lib.charts.PieChart;

public class storel1dashboard extends AppCompatActivity {
    TextView tvpending, tvhandovered, tvhsf, tvclosed,tvosr;
    ImageButton b1,b2,b3;
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storel1dashboard);
        b1=findViewById(R.id.sparemov);
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
                Intent i=new Intent(storel1dashboard.this, storel1home.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storel1dashboard.this, storel1_sparemov.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storel1dashboard.this, storel1profile.class);
                startActivity(i);
            }
        });


    }
}
