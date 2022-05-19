package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class NewUserActivity extends Activity {
    //private String userName;
    //private String phoneNumber;
    //protected String password;

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
        if(username.isEmpty() || username.equals("Username") || password.isEmpty() || password.equals("Password") || pNumber.equals("Number") || pNumber.isEmpty()){
            System.out.println("Wrong input try again");
        }else{
            // TODO: 13/05/2022 databank linken
            // TODO: 10/05/2022 (niet belangrijk) zorgen dat eens je op het main screen ben je niet terug kan naar NewUserActivity
            System.out.println(username);
            System.out.println(password);
            UserProfile user = new UserProfile(username, password, pNumber);
            app.setUser(user);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
