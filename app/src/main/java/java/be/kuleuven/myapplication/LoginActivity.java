package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends Activity {
    // dit is klaar enkel nog de link tussen de database leggen bij login
    private UserProfile userProfile;
    private RequestQueue requestQueue;
    private String usernameFromDb;
    private String passwordFromDb;
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
        MediaPlayer mp = MediaPlayer.create(LoginActivity.this, R.raw.queen_bicycle);
        mp.start();

    }
    // check login input with the database, if ok forwards to MainActivity screen
    public void login(String username, String password){
        if(username.isEmpty() || username.equals("Username") || password.isEmpty() || password.equals("Password")){
            System.out.println("wrong input");
            //get data from database




        }else{
            System.out.println();
            System.out.println(username);
            System.out.println(password);
            System.out.println();


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
                                    System.out.println("username from db = " + usernameFromDb);
                                    if (username.equals(usernameFromDb) && password.equals(passwordFromDb))
                                    {
                                        UserProfile user = new UserProfile(username, password);
                                        app.setUser(user);
                                        //send to MainActivity screen
                                        goNext();

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
        }
    }

    // forward to NewUserActivity screen
    public void goNewUserActivity(){
        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }

    public void goNext()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}