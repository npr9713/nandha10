package com.example.cmrlproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class zjeprofile extends AppCompatActivity {
    Button b1;
    ImageButton b2, b3, b4,b5;
    TextView t1, t2, t3, t4;
    String token,eid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zjeprofile);
        Intent i = getIntent();
        token = i.getStringExtra("token");
        new zjeprofile.ProfileDataTask().execute("https://98bb-2401-4900-6323-51b1-741b-7ac2-15bb-9d07.ngrok-free.app/cmo_profile");

        t1=(TextView) findViewById(R.id.enamep);
        t2=(TextView) findViewById(R.id.eidp);
        t3=(TextView) findViewById(R.id.eemailp);
        t4=(TextView) findViewById(R.id.ephonep);
        b1=(Button) findViewById(R.id.logoutb);
        b2=(ImageButton)  findViewById(R.id.approvereq);
        b3=(ImageButton)  findViewById(R.id.homebut);
        b4=(ImageButton)  findViewById(R.id.viewreqbut);
        b5 = (ImageButton) findViewById(R.id.dashboardbut);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("mypref",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("AccessToken-zje",null);
                editor.apply();
                Intent i = new Intent(zjeprofile.this, MainActivity.class);
                i.putExtra("token", token);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zjeprofile.this, zjeapprovereq.class);
                i.putExtra("token", token);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zjeprofile.this, zjehome.class);
                i.putExtra("token", token);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zjeprofile.this, zjeviewreq.class);
                i.putExtra("token", token);
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zjeprofile.this, zjedashboard.class);
                i.putExtra("token", token);
                startActivity(i);

            }
        });
    }
    private class ProfileDataTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String urlString = params[0];
            try {
                URL url = new URL(urlString);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setRequestProperty("Authorization", "Bearer " + token);

                urlConnection.setDoOutput(true);
                urlConnection.setDoInput(true);

                // Read the input stream into a String
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }

                bufferedReader.close();
                return stringBuilder.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                try {
                    // Parse the JSON response
                    JSONObject jsonResponse = new JSONObject(result);

                    // Check for token expiration response
                    if (jsonResponse.has("message") && "Unauthorized: Invalid token".equals(jsonResponse.getString("message"))) {
                        // Token is expired or invalid, redirect to login page
                        showTokenExpiredAlert();
                    } else {
                        // Continue processing other responses
                        // Parse the JSON response
                        // Update the UI
                        parseAndDisplayResponse(jsonResponse);
                    }
                } catch (JSONException e) {
                    Log.e("API Error", "Error parsing JSON response", e);
                }
            } else {
                // Handle the case where the result is null
                Toast.makeText(zjeprofile.this, "Error fetching data from server", Toast.LENGTH_SHORT).show();
            }
        }

        private void parseAndDisplayResponse(JSONObject jsonResponse) {
            try {
                // Extract values from the JSON response
                eid = jsonResponse.getJSONObject("success").getString("eid");
                String name = jsonResponse.getJSONObject("success").getString("name");
                String email = jsonResponse.getJSONObject("success").getString("email");
                String phone = jsonResponse.getJSONObject("success").getString("phone");

                // Set the values to corresponding TextViews
                t1.setText(name);
                t2.setText(eid);
                t3.setText(email);
                t4.setText(phone);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private void showTokenExpiredAlert() {
            AlertDialog.Builder builder = new AlertDialog.Builder(zjeprofile.this); // Pass the context of l1profile activity
            builder.setTitle("Session Expired");
            builder.setMessage("Your session has expired. Please log in again.");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // Redirect to login page
                    redirectToLoginPage();
                }
            });
            builder.show();
        }

        private void redirectToLoginPage() {
            SharedPreferences sharedPreferences = getSharedPreferences("mypref",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("AccessToken-zje",null);
            editor.apply();
            Intent intent = new Intent(zjeprofile.this, zjelogin.class); // Change to your login activity
            startActivity(intent);
            finish();  // Optional: Close the current activity if needed
        }
    }

}