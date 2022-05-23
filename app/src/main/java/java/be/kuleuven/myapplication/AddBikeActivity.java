package java.be.kuleuven.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

public class AddBikeActivity extends Activity {
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bike);
        Button addBikeButton = (Button) findViewById(R.id.addBike);
        EditText descriptionEdit = findViewById(R.id.descriptionInput);
        addBikeButton.setOnClickListener(v -> addBike(descriptionEdit.getText().toString()));
    }
    @SuppressLint("SetTextI18n")
    public void addBike(String description) {
        TextView tv1 = (TextView)findViewById(R.id.actionMessage);
        if (!description.equals("Name") && !(App.getUser().isMemberBikeList(description))) {
            Bike addBike = new Bike(App.getUser().getBikeList().size() + 1, description);
            App.getUser().addBikeList(addBike);
            //database toevoegen
            /*
            requestQueue = Volley.newRequestQueue(this);
            String requestURL = "https://studev.groept.be/api/a21pt112/addBike";
            requestURL = requestURL + "/" + App.getUser().getUserName() + "/" + addBike.getDescription() + "/" + addBike.getNumber();
            StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,
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

             */
            tv1.setText("SUCCEEDED");
        } else{
            tv1.setText("FAILED");
        }
    }
}