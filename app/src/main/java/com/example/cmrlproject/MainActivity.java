package com.example.cmrlproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    private Button getStartedButton;
    private int userType = 0;
    private RadioGroup radioGroup;

    String token,ctoken,ztoken;



    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getSharedPreferences("mypref",MODE_PRIVATE);
        token = sharedPreferences.getString("AccessToken-l1","no");
        ctoken = sharedPreferences.getString("AccessToken-cmo","no");
        ztoken = sharedPreferences.getString("AccessToken-zje","no");
            Log.d("ctoken",ctoken);
            Log.d("token",token);

        if(!(Objects.equals(token, "no")))
        {
            Log.d("token",token);
            Intent i = new Intent(MainActivity.this,l1profile.class);
            i.putExtra("token",token);
            startActivity(i);

        }
        if(!(Objects.equals(ctoken, "no")))
        {
            Log.d("token",ctoken);
            Intent i = new Intent(MainActivity.this,cmoprofile.class);
            i.putExtra("token",ctoken);
            startActivity(i);

        }
        if(!(Objects.equals(ztoken, "no")))
        {
            Log.d("token",ctoken);
            Intent i = new Intent(MainActivity.this,zjeprofile.class);
            i.putExtra("token",ztoken);
            startActivity(i);

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getStartedButton = findViewById(R.id.button3);
        radioGroup = findViewById(R.id.radioGroup);






        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.checkbox01) {
                    userType = 0;
                } else if (checkedId == R.id.checkbox02) {
                    userType = 1;
                } else if (checkedId == R.id.checkbox03) {
                    userType = 2;
                }
                else if (checkedId==R.id.checkbox04) {
                    userType=3;

                }
            }
        });

        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent;
                    switch (userType) {
                        case 0:
                            intent = new Intent(MainActivity.this, cmologin.class);
                            startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(MainActivity.this, zjelogin.class);
                            startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(MainActivity.this, l1login.class);
                            startActivity(intent);
                            break;
                        case 3:
                            intent = new Intent(MainActivity.this, storelogin.class);
                            startActivity(intent);
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
