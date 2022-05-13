package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        Button toMain = findViewById(R.id.submitButton);
        EditText UserNameEdit = findViewById(R.id.usernameInput2);
        EditText PasswordEdit = findViewById(R.id.passwordInput2);
        EditText PNumberEdit = findViewById(R.id.pNumberInput2);
        toMain.setOnClickListener(v -> checkInput(UserNameEdit.getText().toString(), PasswordEdit.getText().toString(), PNumberEdit.getText().toString()));
    }

    private void checkInput(String userName, String password, String phoneNumber){
        System.out.println("userName: " + userName);
        System.out.println("password: " + password);
        System.out.println("number: " + phoneNumber);
    }

    private void toMainActivity() {
        // TODO: 10/05/2022 stream maken van atributen van username, dan nagaan of al de atributen zijn ingevuld,
        //  zoniet error message, zowel kan op op submit geduuwd worden
        // TODO: 10/05/2022 (niet belangrijk) zorgen dat eens je op het main screen ben je niet terug kan naar NewUserActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
