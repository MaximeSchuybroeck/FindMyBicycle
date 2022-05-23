package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NewUserActivity extends Activity {
    //private String userName;
    //private String phoneNumber;
    //protected String password;
    private RequestQueue requestQueue;
    private RequestQueue requestQueue1;
    private String usernameFromDb;
    private int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        // UserProfile newUser = new UserProfile("", "", "");
        //submit button
        Button SubmitButton = findViewById(R.id.submitButton);
        EditText UserNameEdit = findViewById(R.id.usernameInput2);
        EditText PasswordEdit = findViewById(R.id.passwordInput2);
        EditText PNumberEdit = findViewById(R.id.pNumberInput2);

        SubmitButton.setOnClickListener(v -> checkInput(UserNameEdit.getText().toString(), PasswordEdit.getText().toString(), PNumberEdit.getText().toString()));
        MediaPlayer mp = MediaPlayer.create(NewUserActivity.this, R.raw.queen_bicycle);
        mp.start();
    }

    private void checkInput(String username, String password, String pNumber){
        if(username.isEmpty() || username.equals("Username") || password.isEmpty() || password.equals("Password") || pNumber.equals("Number")){
            System.out.println("Wrong input try again");
            TextView tv1 = (TextView)findViewById(R.id.actionMessage);
            tv1.setText("FAILED");
        }



        else{

            // TODO: 10/05/2022 (niet belangrijk) zorgen dat eens je op het main screen ben je niet terug kan naar NewUserActivity
            System.out.println(username);
            System.out.println(password);
            //add new user but first check if user doesn't exist
            requestQueue = Volley.newRequestQueue(this);
            String requestURL = "https://studev.groept.be/api/a21pt112/getLoginData";
            String postURL = "https://studev.groept.be";
            StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray responseArray = new JSONArray(response);
                                for (int i = 0; i < responseArray.length(); i++) {
                                    JSONObject currentJSonObject = responseArray.getJSONObject(i);
                                    usernameFromDb = currentJSonObject.getString("username");
                                    System.out.println("username from db = " + usernameFromDb);
                                    if (username.equals(usernameFromDb))
                                    {
                                        counter++;
                                    }
                                }
                                //counter is used to check in database if user already exists
                                if (counter == 0)
                                {
                                    // choose constructor based on pNumber
                                    if (pNumber.equals("")) {
                                        //add user to database !!!!!!!!!!Nog niet af
                                        UserProfile newProfile = new UserProfile(username, password);
                                        new App();
                                        App.setUser(newProfile);
                                        goNext();
                                        StringRequest addRequest = new StringRequest(Request.Method.POST, requestURL,
                                                response1 -> Toast.makeText(NewUserActivity.this, "Succes", Toast.LENGTH_LONG).show(),
                                                error -> Toast.makeText(NewUserActivity.this, "Error", Toast.LENGTH_LONG).show()){
                                            @Override
                                            protected Map<String, String> getParams() throws AuthFailureError{
                                                Map<String, String> params = new HashMap<>();
                                                params.put("Username", username );
                                                params.put("Password", password);
                                                return params;
                                            }
                                            };
                                        requestQueue1 = Volley.newRequestQueue(NewUserActivity.this);
                                        requestQueue1.add(addRequest);
                                        }
                                    else
                                    {
                                        //make user and set it to active user
                                        UserProfile newProfile = new UserProfile(username,password, pNumber);
                                        new App();
                                        App.setUser(newProfile);
                                        goNext();
                                        // add user to db

                                    }
                                }
                                else
                                {
                                    TextView tv1 = (TextView)findViewById(R.id.actionMessage);
                                    tv1.setText("FAILED");
                                }

                                System.out.println(username + "  "+ password);
                                }
                            catch (JSONException e) {
                                Log.e("database", e.getMessage(), e);
                            }
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.println(error.getLocalizedMessage());
                        }
                    }
            );
            requestQueue.add(submitRequest);
            }

    }
    public void goNext() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
