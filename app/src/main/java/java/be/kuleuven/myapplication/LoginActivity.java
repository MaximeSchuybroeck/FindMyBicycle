package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {
    // maxime fixt dees
    private UserProfile userProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // New User button stuff
        Button addUserButton = (Button) findViewById(R.id.newUserButton);
        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toNewUserActivity();
            }
        });
        Button loginButton = (Button) findViewById(R.id.newUserButton);
        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toNewUserActivity();
            }
        });
        MediaPlayer mp = MediaPlayer.create(LoginActivity.this, R.raw.queen_bicycle);
        mp.start();
    }
    // to login en check with the database, then forwards you to the begin screen( the manage screen)
    public void login(String username, String password){
        // TODO: 2/05/2022 in database kijken of dit account bestaat


        //send to MainActivity screen
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    // the NewUser button link to NewUserActivity screen
    public void toNewUserActivity(){
        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }
}