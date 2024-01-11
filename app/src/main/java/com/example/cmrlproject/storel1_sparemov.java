package com.example.cmrlproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class storel1_sparemov extends AppCompatActivity {
    ImageButton b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storel1_sparemov);
        b1=findViewById(R.id.homebut);
        b2=findViewById(R.id.dashboardbut);
        b3=findViewById(R.id.profilebut);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storel1_sparemov.this, storel1dashboard.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storel1_sparemov.this, storel1profile.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storel1_sparemov.this, storel1home.class);
                startActivity(i);
            }
        });

    }
}
