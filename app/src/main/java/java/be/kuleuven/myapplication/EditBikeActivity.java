package java.be.kuleuven.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EditBikeActivity extends Activity {
    private RequestQueue requestQueue;
    private RequestQueue requestQueue2;
    private RequestQueue requestQueue3;
    private RequestQueue requestQueue4;
    private String username, bikeNumber,bikeIdFromDb, bikeDescription, longitude, latitude ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bike);
        //changeDescription
        Button editDescription = (Button) findViewById(R.id.editBikeDescription);
        AutoCompleteTextView descriptionEdit = findViewById(R.id.bicycle_description);
        descriptionEdit.setText(App.getEditBike().getDescription());
        editDescription.setOnClickListener(v -> changeDescription(descriptionEdit.getText().toString()));
    }

    @SuppressLint("SetTextI18n")
    private void changeDescription(String description) {
        if(!description.isEmpty() && !description.equals(App.getEditBike().getDescription())){
            App.getEditBike().setDescription(description);
            //gets the id of the bike that needs to be deleted
            requestQueue = Volley.newRequestQueue(this);
            String requestURL = "https://studev.groept.be/api/a21pt112/getBikeId";



            requestURL = requestURL + "/" + App.getUser().getUserName() + "/" + App.getEditBike().getNumber();
            StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray responseArray = new JSONArray(response);
                                JSONObject currentJSonObject = responseArray.getJSONObject(0);
                                bikeIdFromDb = currentJSonObject.getString("bike_id");
                                App.setToBeDeletedBikeId(bikeIdFromDb);

                                //get needed data to make new bike after it's edited
                                username = App.getUser().getUserName();
                                bikeNumber = App.getEditBike().getNumber();
                                bikeDescription = App.getEditBike().getDescription();
                                //bike id is retrieved from db in query above

                                //method makes connection to Db and gets the location of the bike we're gonna change
                                getLocationFromDb();



                            } catch (Exception e) {
                                Log.e("database", e.getMessage(), e);
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.println(error.getLocalizedMessage());
                        }
                    }

            );
            requestQueue.add(submitRequest);
        } else{
            TextView tv3 = (TextView)findViewById(R.id.actionMessage);
            tv3.setText("FAILED");
        }

    }

    private void getLocationFromDb() {
        requestQueue4 = Volley.newRequestQueue(this);
        String requestURL3 = "https://studev.groept.be/api/a21pt112/getLocationId";
        requestURL3 += "/" + bikeIdFromDb;
        System.out.println(requestURL3);
        StringRequest submitRequest3 = new StringRequest(Request.Method.GET, requestURL3,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray responseArray = new JSONArray(response);
                            longitude = responseArray.getJSONObject(0).getString("longitude");
                            latitude = responseArray.getJSONObject(0).getString("latitude");

                            //deletes the old bike
                            secondQueryDeleteBike();
                        } catch (JSONException e) {
                            Log.e("database", e.getMessage(), e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error.getLocalizedMessage());
                    }

                });
        requestQueue4.add(submitRequest3);
    }



    public void secondQueryDeleteBike(){
        //deletes the old bike
        requestQueue2 = Volley.newRequestQueue(this);
        String requestURL2 = "https://studev.groept.be/api/a21pt112/deleteBike";
        requestURL2 = requestURL2 + "/" + App.getToBeDeletedBikeId();
        System.out.println(requestURL2);
        StringRequest submitRequest2 = new StringRequest(Request.Method.GET, requestURL2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray responseArray = new JSONArray(response);

                            // adds the adjusted bike
                            thirdQueryAddBike();
                        } catch (JSONException e) {
                            Log.e("database", e.getMessage(), e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error.getLocalizedMessage());
                    }
                }
        );
        requestQueue2.add(submitRequest2);
    }

    public void thirdQueryAddBike(){
        // adds the adjusted bike
        requestQueue3 = Volley.newRequestQueue(this);
        String requestURL3 = "https://studev.groept.be/api/a21pt112/addBike";
        requestURL3 = requestURL3 + "/" + App.getUser().getUserName() + "/" + App.getEditBike().getDescription() + "/" + App.getEditBike().getNumber();



        StringRequest submitRequest3 = new StringRequest(Request.Method.GET, requestURL3,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray responseArray = new JSONArray(response);
                            TextView tv3 = (TextView)findViewById(R.id.actionMessage);
                            tv3.setText("SUCCEEDED");
                            System.out.println("####################### test 3 addNewbike ");
                            //adds old location to the bike
                            lastQueryAddLocationToBike();
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
        requestQueue3.add(submitRequest3);
    }

    private void lastQueryAddLocationToBike() {
        requestQueue4 = Volley.newRequestQueue(this);
        String requestURL4 = "https://studev.groept.be/api/a21pt112/addLocation";
        requestURL4 += "/" + username + "/" + bikeDescription + "/" + bikeNumber + "/" + longitude + "/" + latitude;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, requestURL4,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray responseArray = new JSONArray(response);
                        } catch (JSONException e) {
                            Log.e("database", e.getMessage(), e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error.getLocalizedMessage());
                    }
                });
                requestQueue4.add(stringRequest);
    }


}
