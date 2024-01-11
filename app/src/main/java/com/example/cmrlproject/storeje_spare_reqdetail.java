package com.example.cmrlproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class storeje_spare_reqdetail extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;

    ImageButton b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storeje_spare_reqdetail);

        t1=findViewById(R.id.reqtype);
        t2=findViewById(R.id.date);
        t3=findViewById(R.id.station);
        t4=findViewById(R.id.slename);
        t5=findViewById(R.id.sleno);
        t6=findViewById(R.id.uniname);
        t7=findViewById(R.id.sparereq);
        t8=findViewById(R.id.reqby);
        t9=findViewById(R.id.fspareslno);
        t10=findViewById(R.id.fdesc);
        t11=findViewById(R.id.frstation);
        t12=findViewById(R.id.frsle);
        t13=findViewById(R.id.frsleno);
        t14=findViewById(R.id.wsno);
        t15=findViewById(R.id.mrid);

        b2=findViewById(R.id.homebut);
        b3=findViewById(R.id.dashboardbut);
        b4=findViewById(R.id.profilebut);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storeje_spare_reqdetail.this, storejedashboard.class);
                startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storeje_spare_reqdetail.this, storejeprofile.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(storeje_spare_reqdetail.this, storejehome.class);
                startActivity(i);
            }
        });


    }


}
