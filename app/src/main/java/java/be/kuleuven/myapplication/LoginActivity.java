package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class LoginActivity extends Activity {
    // dit is klaar enkel nog de link tussen de database leggen bij login
    private UserProfile userProfile;
    private RequestQueue requestQueue;
    private RequestQueue requestQueue2;
    private String usernameFromDb;
    private String passwordFromDb;
    private String phoneNumberFromDb;
    private String bikeDisFromDb;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // New User button
        Button addUserButton = findViewById(R.id.newUserButton);
        addUserButton.setOnClickListener(v -> goNewUserActivity());
        // login button and login input
        Button loginButton = findViewById(R.id.loginButton);
        EditText UserNameEdit = findViewById(R.id.usernameInput);
        EditText PasswordEdit = findViewById(R.id.passwordInput);
        loginButton.setOnClickListener(v -> login(UserNameEdit.getText().toString(), PasswordEdit.getText().toString()));

        //music
        mp = MediaPlayer.create(LoginActivity.this, R.raw.queen_bicycle);
        mp.start();
        System.out.println("test1");
    }
    // check login input with the database, if ok forwards to MainActivity screen
    public void login(String username, String password){
        if(username.isEmpty() || username.equals("Username") || password.isEmpty() || password.equals("Password")){
            System.out.println("wrong input");
            System.out.println("test2");
            //get data from database




        }else{
            System.out.println("test3");
            requestQueue = Volley.newRequestQueue(this);
            String requestURL = "https://studev.groept.be/api/a21pt112/getLoginData";
            StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray responseArray = new JSONArray(response);
                                for (int i = 0; i < responseArray.length(); i++) {
                                    JSONObject currentJSonObject = responseArray.getJSONObject(i);
                                    usernameFromDb = currentJSonObject.getString("username");
                                    passwordFromDb = currentJSonObject.getString("password");
                                    phoneNumberFromDb = currentJSonObject.getString("phonenumber");
                                    System.out.println("username from db = " + usernameFromDb);
                                    if (username.equals(usernameFromDb) && password.equals(passwordFromDb))
                                    {
                                        UserProfile user = new UserProfile(username, password);
                                        new App();
                                        App.setUser(user);
                                        if (phoneNumberFromDb != null)
                                        {
                                            App.getUser().setPhoneNumber(phoneNumberFromDb);
                                        }
                                        secondQueryLoadBikeList();
                                    }
                                }
                                System.out.println(usernameFromDb + "  " + passwordFromDb);

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
            System.out.println("test4");
            //loads the bikelist
        }
    }

    // forward to NewUserActivity screen
    public void goNewUserActivity(){
        mp.release();
        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);

    }

    public void goNext() {
        mp.release();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void secondQueryLoadBikeList(){
        System.out.println("test5");
        requestQueue2 = Volley.newRequestQueue(this);
        String requestURL2 = "https://studev.groept.be/api/a21pt112/getBikeFromUsername";
        requestURL2 = requestURL2 + "/" + App.getUser().getUserName();
        StringRequest submitRequest2 = new StringRequest(Request.Method.GET, requestURL2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray responseArray = new JSONArray(response);
                            ArrayList<Bike> addList = new ArrayList<>();
                            for (int i = 0; i < responseArray.length(); i++) {
                                JSONObject currentJSonObject = responseArray.getJSONObject(i);
                                bikeDisFromDb = currentJSonObject.getString("description");
                                Bike addBike = new Bike(Integer.toString(i + 1), bikeDisFromDb);
                                addList.add(addBike);
                            }
                            App.getUser().setBikeList(addList);
                            goNext();
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
}