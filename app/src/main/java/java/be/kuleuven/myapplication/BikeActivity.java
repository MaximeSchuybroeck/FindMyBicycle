package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;

public class BikeActivity extends Activity {
    //private UserProfile owner;
    //private Bike bike;
    //private BikeLocation bikeLocation;
    private static Bike bike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike);
        //works till here
        //addBike
        Button addBikeButton = findViewById(R.id.button);
        addBikeButton.setOnClickListener(v -> addBike());
        //addLocation
        Button addLocationButton = findViewById(R.id.addLocation);
        addLocationButton.setOnClickListener(v -> addLocation());
        //editBicycle
        Button editBikeButton = findViewById(R.id.editBicycle);
        // TODO: 13/05/2022 lijn eronder nog aanpassen naar een Bike input
        editBikeButton.setOnClickListener(v -> editBike());

    }

    public void addBike() {
        //go to add bike screen
        //make a bike and later add it to the bike list
        Intent intent = new Intent(this, AddBikeActivity.class);
        startActivity(intent);
    }

    public void addLocation() {
        //go to select bike and automatically add the location of that instance to the selected bike
        Intent intent = new Intent(this, ChooseBikeActivity.class);
        startActivity(intent);
    }

    public void editBike() {
        //go to edit bike screen
        Intent intent = new Intent(this, EditBikeActivity.class);
        startActivity(intent);
    }

}

