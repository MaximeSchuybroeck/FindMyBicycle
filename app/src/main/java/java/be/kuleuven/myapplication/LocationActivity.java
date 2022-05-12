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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

public class LocationActivity extends Activity {
    public static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    double longitude, latitude;
    TextView textView;
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
        if (ActivityCompat.checkSelfPermission(LocationActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (LocationActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(LocationActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            Location location1 = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

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
                double longi = getLongitude();
                double lati = getLatitude();
                return ("position is" + "\n"+ "longitude: " + String.valueOf(longi)+  "\n" + "latitude:" + String.valueOf(lati));
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


