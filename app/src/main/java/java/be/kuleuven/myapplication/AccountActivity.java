package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class AccountActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //editUsername
        Button editUsernameButton = findViewById(R.id.editUsername);
        AutoCompleteTextView userNameEdit = findViewById(R.id.autoCompleteTextView);
        userNameEdit.setText(App.getUser().getUserName());
        editUsernameButton.setOnClickListener(v -> editUsername(userNameEdit.getText().toString()));

        //editPassword
        Button editPasswordButton = findViewById(R.id.editPassword);
        AutoCompleteTextView passwordEdit = findViewById(R.id.autoCompleteTextView2);
        passwordEdit.setText(App.getUser().getPassword());
        editPasswordButton.setOnClickListener(v -> editPassword(passwordEdit.getText().toString()));

        //editPhoneNumber
        Button editPNumberButton = findViewById(R.id.editPhonenumber);
        AutoCompleteTextView pNumberEdit = findViewById(R.id.autoCompleteTextView3);
        pNumberEdit.setText(App.getUser().getPhoneNumber());
        editPNumberButton.setOnClickListener(v -> editPNumber(pNumberEdit.getText().toString()));


    }

    private void editPNumber(String newPNumber) {
        if (!newPNumber.isEmpty() || !newPNumber.equals(App.getUser().getPhoneNumber())){
            App.getUser().setPhoneNumber(newPNumber);
        }
    }

    private void editPassword(String newPassword) {
        if (!newPassword.isEmpty() || !newPassword.equals(App.getUser().getPassword())){
            App.getUser().setPassword(newPassword);
        }
    }

    private void editUsername(String newName) {
        if (!newName.isEmpty() || !newName.equals(App.getUser().getUserName())){
            App.getUser().setUserName(newName);
        }
    }
}
