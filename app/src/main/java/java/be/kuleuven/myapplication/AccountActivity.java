package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class AccountActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //editUsername
        Button editUsernameButton = findViewById(R.id.editUsername);
        AutoCompleteTextView userNameEdit = findViewById(R.id.autoCompleteTextView);
        userNameEdit.setText(app.getUser().getUserName());
        editUsernameButton.setOnClickListener(v -> editUsername(userNameEdit.getText().toString()));

        //editPassword
        Button editPasswordButton = findViewById(R.id.editPassword);
        AutoCompleteTextView passwordEdit = findViewById(R.id.autoCompleteTextView2);
        passwordEdit.setText(app.getUser().getPassword());
        editPasswordButton.setOnClickListener(v -> editPassword(passwordEdit.getText().toString()));

        //editPhoneNumber
        Button editPNumberButton = findViewById(R.id.editPhonenumber);
        AutoCompleteTextView pNumberEdit = findViewById(R.id.autoCompleteTextView3);
        pNumberEdit.setText(app.getUser().getPhoneNumber());
        editPNumberButton.setOnClickListener(v -> editPNumber(pNumberEdit.getText().toString()));


    }

    private void editPNumber(String newPNumber) {
        if (!newPNumber.isEmpty() || !newPNumber.equals(app.getUser().getPhoneNumber())){
            app.getUser().setPhoneNumber(newPNumber);
        }
    }

    private void editPassword(String newPassword) {
        if (!newPassword.isEmpty() || !newPassword.equals(app.getUser().getPassword())){
            app.getUser().setPassword(newPassword);
        }
    }

    private void editUsername(String newName) {
        if (!newName.isEmpty() || !newName.equals(app.getUser().getUserName())){
            app.getUser().setUserName(newName);
        }
    }
}
