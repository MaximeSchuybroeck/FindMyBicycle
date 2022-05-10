package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewUserActivity extends Activity {
    private UserProfile newUser;
    private String userName;
    private String phoneNumber;
    protected String password;
    private String firstName;
    private String lastName;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        newUser = new UserProfile("","","","","");
        Button toMain = (Button) findViewById(R.id.submitButton);
        toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainActivity();
            }
        });
    }

    private void toMainActivity() {
        // TODO: 10/05/2022 stream maken van atributen van username, dan nagaan of al de atributen zijn ingevuld,
        //  zoniet error message, zowel kan op op submit geduuwd worden
        // TODO: 10/05/2022 (niet belangrijk) zorgen dat eens je op het main screen ben je niet terug kan naar NewUserActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void setFirstName(String name){

    }
}
