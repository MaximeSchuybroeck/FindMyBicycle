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
import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationActivity2 extends AppCompatActivity {
    Button btLocation;
    AutoCompleteTextView textView1;
    TextView textView2;
    FusedLocationProviderClient fusedLocationProviderClient;
    Button bt_add_location;
    RequestQueue requestQueueToAdd;
    RequestQueue requestQueueForDelete;
    RequestQueue idRequestQueue;
    String id;
    String longitude, latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location2);

        //assign variables
        btLocation = findViewById(R.id.bt_location);
        textView1 = findViewById(R.id.textLocationView);
        textView2 = findViewById(R.id.textView5);
        bt_add_location = findViewById(R.id.bt_add_location);

        btLocation.setOnClickListener(v -> getCurrentBikeLocation());


        //used to get current location
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        bt_add_location.setOnClickListener(v -> {
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
                        longitude = Double.toString(location.getLongitude());
                        latitude = Double.toString(location.getLatitude());
                        //Set latitude on TextView
                        String newText = "Current Location: " + Double.toString(addresses.get(0).getLatitude()) + "  , " + Double.toString(addresses.get(0).getLongitude());
                        textView1.setText(newText);
                        ///ADD LOCATION TO DATABASE



                        //get all needed data to delete data from database and add new data for location
                        String username = App.getUser().getUserName();
                        String description = App.getEditBike().getDescription();
                        String bikeNumber = String.valueOf(App.getEditBike().getNumber());


                        // get bike id
                        idRequestQueue = Volley.newRequestQueue(LocationActivity2.this);
                        String idURL = "https://studev.groept.be/api/a21pt112/getBikeId";
                        idURL += "/" + username + "/" + bikeNumber;
                        StringRequest idRequest = new StringRequest(Request.Method.GET, idURL,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        try {
                                            JSONArray responseArray = new JSONArray(response);
                                            id = responseArray.getJSONObject(0).toString();

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
                        idRequestQueue.add(idRequest);


                        //delete old userinfo from database
                        requestQueueForDelete = Volley.newRequestQueue(LocationActivity2.this);
                        String deleteURL = "https://studev.groept.be/api/a21pt112/deleteBike/id";
                        deleteURL += "/" + id;
                        StringRequest deleteRequest = new StringRequest(Request.Method.GET, deleteURL,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {

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
                        requestQueueForDelete.add(deleteRequest);


                        //Finally add the info to the database
                        requestQueueToAdd = Volley.newRequestQueue(LocationActivity2.this);
                        String requestURL = "https://studev.groept.be/api/a21pt112/addLocation";
                        /////////////////////////////////////////////////////////////

                        /////HIER ZIT ERGENS EEN FOUT WANT HIJ ADD NIET AAN DE DATABANK MAAR STAPT WEL IN DE ONRESPONSE

                        /////////////////////////////////////////////////////////////
                        requestURL += "/" + username + "/" + description + "/" + bikeNumber + "/" + longitude + "/" + latitude ;
                        StringRequest addRequest = new StringRequest(Request.Method.GET, requestURL,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        try {
                                            JSONArray responseArray = new JSONArray(response);
                                            System.out.println("location added");

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
                        requestQueueToAdd.add(addRequest);



                    }
                        catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void getCurrentBikeLocation()
    {
        requestQueueToAdd = Volley.newRequestQueue(LocationActivity2.this);
        String getLocationURL = "https://studev.groept.be/api/a21pt112/getLocationId";
        getLocationURL += "/" + App.getEditBike().getNumber();
        StringRequest addRequest = new StringRequest(Request.Method.GET, getLocationURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray responseArray = new JSONArray(response);
                            longitude = responseArray.getJSONObject(0).getString("longitude");
                            latitude = responseArray.getJSONObject(0).getString("latitude");
                            System.out.println("location retrieved");
                            String retrievedLocation = latitude + " , " + longitude;
                            textView1.setText(retrievedLocation);
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
        requestQueueToAdd.add(addRequest);

    }
}