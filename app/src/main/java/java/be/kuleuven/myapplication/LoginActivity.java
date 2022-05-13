package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
    // dit is klaar enkel nog de link tussen de database leggen bij login
    private UserProfile userProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // New User button
        Button addUserButton = findViewById(R.id.newUserButton);
        addUserButton.setOnClickListener(v -> toNewUserActivity());
        // login button and login input
        Button loginButton = findViewById(R.id.loginButton);
        EditText UserNameEdit = findViewById(R.id.username_input);
        EditText PasswordEdit = findViewById(R.id.password_input);
        loginButton.setOnClickListener(v -> login(UserNameEdit.getText().toString(), PasswordEdit.getText().toString()));
        // music
        MediaPlayer mp = MediaPlayer.create(LoginActivity.this, R.raw.queen_bicycle);
        mp.start();
    }
    // check login input with the database, if ok forwards to MainActivity screen
    public void login(String username, String password){
        if(username.equals("") || password.equals("")){
            System.out.println("Wrong input. Try again");
        }else{
            // TODO: 2/05/2022 in database kijken of dit account bestaat
            System.out.println(username);
            System.out.println(password);
            //send to MainActivity screen
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    // forward to NewUserActivity screen
    public void toNewUserActivity(){
        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }
}