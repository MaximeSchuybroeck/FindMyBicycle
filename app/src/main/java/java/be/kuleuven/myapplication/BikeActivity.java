package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.Manifest;
import android.annotation.SuppressLint;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class BikeActivity extends Activity {
    //private UserProfile owner;
    //private Bike bike;
    //private BikeLocation bikeLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike);
        //works till here

        Button addBikeButton = (Button) findViewById(R.id.button);
        addBikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBike();
            }

        });

        Button addBikeLocationButton = (Button) findViewById(R.id.addLocation);
        addBikeLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    addBikeLocation();
                }
            }
        });

        Button editBikeButton = (Button) findViewById(R.id.editBicycle);
        editBikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editBike();
            }
        });

        Button findBikeButton = findViewById(R.id.findLocation);
        findBikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findBike();
            }
        });



    }


    public void addBike()
    {
        //go to add bike screen
        // make a bike and later add it to the bike list
        Intent intent = new Intent(this, AddBikeActivity.class);
        startActivity(intent);
    }

    public void addBikeLocation()
    {
        //go to select bike and automatically add the location of that instance to the selected bike
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }

    public void editBike()
    {
        //go to edit bike screen
        Intent intent = new Intent(this, EditBikeActivity.class);
        startActivity(intent);
    }

    public void findBike()
    {

    }
}

