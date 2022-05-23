package java.be.kuleuven.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationActivity extends Activity {
    public static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    double longitude, latitude;
    TextView textView;
    RequestQueue requestQueue;
    String longitudeFromDB,latitudeFromDB;
    String username, usernameFromDb;
    FusedLocationProviderClient fusedLocationProviderClient;
    //TODO send location to the database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        Button addLocationButton = (Button) findViewById(R.id.addLocation);
        addLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        Button findLocationButton = (Button) findViewById(R.id.findLocation);
        findLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPosition();
                TextView positionView = findViewById(R.id.text_location);
                positionView.setText(getPosition());
            }
        });

        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        textView = (TextView) findViewById(R.id.text_location);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();


        } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            getLocation();
        }
    }

    @SuppressLint("SetTextI18n")
    private void getLocation() {

        //nieuwe code testen





        //








        if (ActivityCompat.checkSelfPermission(LocationActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (LocationActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(LocationActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        } else {
            @SuppressLint("MissingPermission")
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            @SuppressLint("MissingPermission")
            Location location1 = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            @SuppressLint("MissingPermission")
            Location location2 = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

            if (location != null) {

                latitude = location.getLatitude();
                longitude = location.getLongitude();

                textView.setText("Your current location is registered");

            } else if (location1 != null) {
                latitude = location1.getLatitude();
                longitude = location1.getLongitude();


                textView.setText("Your current location is registered" );


            } else if (location2 != null) {
                latitude = location2.getLatitude();
                longitude = location2.getLongitude();

                textView.setText("Your current location is registered");

            } else {

                Toast.makeText(this, "Unable to Trace your location", Toast.LENGTH_SHORT).show();

            }


        }
        System.out.println("longitude and latitude is :" + longitude + latitude);

    }

            protected void buildAlertMessageNoGps () {

                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Please Turn ON your GPS Connection")
                        .setCancelable(false)
                        .setPositiveButton("Yes", (dialog, id) -> startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)))
                        .setNegativeButton("No", (dialog, id) -> dialog.cancel());
                final AlertDialog alert = builder.create();
                alert.show();
            }

            public String getPosition()
            {
                requestQueue = Volley.newRequestQueue(this);
                String requestURL = "https://studev.groept.be/api/a21pt112/getLocationData";
                StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONArray responseArray = new JSONArray(response);
                                    for (int i = 0; i < responseArray.length(); i++) {
                                        JSONObject currentJSonObject = responseArray.getJSONObject(i);
                                        longitudeFromDB = currentJSonObject.getString("longitude");
                                        latitudeFromDB = currentJSonObject.getString("latitude");
                                        username = App.getUser().getUserName();
                                        usernameFromDb = currentJSonObject.getString("owner");
                                        System.out.println("longitude from db = " + longitudeFromDB + "\n" + "latitude from db = " + latitudeFromDB);
                                        if (username.equals(usernameFromDb))
                                        {
                                            /////////////////////////////////
                                            TextView tv1 = findViewById(R.id.textView);
                                            AutoCompleteTextView tv2 = findViewById(R.id.autoCompleteTextView4);
                                            String wantedLocation = longitudeFromDB + "," + latitudeFromDB;
                                            tv2.setText(wantedLocation);

                                        }
                                    }
                                    System.out.println(usernameFromDb);

                                } catch (JSONException e) {
                                    Log.e("database", e.getMessage(), e);
                                }
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                System.out.println(error.getLocalizedMessage());
                            }
                        }
                );
                requestQueue.add(submitRequest);


                longitude = getLongitude();
                latitude = getLatitude();
                return (longitude + "," + latitude);
            }

            public double getLongitude()
    {
        return this.longitude;
    }

            public double getLatitude()
    {
        return this.latitude;
    }
    }


