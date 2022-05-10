package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {
    // maxime fixt dees
    private UserProfile userProfile;
    private Button addUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addUserButton = (Button) findViewById(R.id.newUserButton);
        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityNewUser();
            }
        });
    }
    // to login en check with the database, then forwards you to the begin screen( the manage screen)
    public void login(String username, String password){
        // TODO: 2/05/2022 in database kijken of dit account bestaat
    }

    public void activityNewUser(){
        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }


    /*
    Button addUser = (Button) findViewById(R.id.newUserButton);
        addUser.setOnClickListener(new View.OnClickListener());

     */


}