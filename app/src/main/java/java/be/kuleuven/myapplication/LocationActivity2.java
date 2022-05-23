package java.be.kuleuven.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationActivity2 extends AppCompatActivity {
    Button btLocation;
    AutoCompleteTextView textView1;
    TextView textView2;
    FusedLocationProviderClient fusedLocationProviderClient;
    Button bt_add_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_location2);

        //assign variables
        btLocation = findViewById(R.id.bt_location);
        textView1 = findViewById(R.id.textLocationView);
        textView2 = findViewById(R.id.textView5);
        bt_add_location = findViewById(R.id.bt_add_location);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        btLocation.setOnClickListener(v -> {
            //check permissions
            if (ActivityCompat.checkSelfPermission(LocationActivity2.this,
                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            {
                //when permission granted
                getLocation();
            }
            else
            {
                //When permission denied
                ActivityCompat.requestPermissions(LocationActivity2.this,
                        new String[]{
                                Manifest.permission.ACCESS_FINE_LOCATION
                        }, 44);
            }
        });

    }
    @SuppressLint("MissingPermission")
    private void getLocation()
    {
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                //initialize location
                Location location = task.getResult();
                if (location != null){

                    try {
                        //initialize geoCoder
                        Geocoder geocoder = new Geocoder(LocationActivity2.this, Locale.getDefault());
                        //initialize address list
                        List<Address> addresses = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1
                        );
                        //Set latitude on TextView
                        String newText = Double.toString(addresses.get(0).getLongitude()) + "  , " + Double.toString(addresses.get(0).getLatitude());
                        textView1.setText(newText);
                        ///ADD LOCATION TO DATABASE

                    }
                        catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}