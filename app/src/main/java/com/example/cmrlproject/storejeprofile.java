package com.example.cmrlproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class storejeprofile extends AppCompatActivity {
    Button b1;
    ImageButton  b3,b4;
    TextView t1, t2, t3, t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storejeprofile);
        t1 = findViewById(R.id.enamep);
        t2 = findViewById(R.id.eidp);
        t3 = findViewById(R.id.eemailp);
        t4 = findViewById(R.id.ephonep);
        b1 = findViewById(R.id.logoutb);

        b3 = findViewById(R.id.homebut);
        b4 = findViewById(R.id.dashboardbut);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(storejeprofile.this, MainActivity.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(storejeprofile.this, storejehome.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(storejeprofile.this, storejedashboard.class);
                startActivity(i);
            }
        });

    }
}
