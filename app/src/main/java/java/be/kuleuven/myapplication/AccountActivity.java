package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AccountActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        //editUsername
        Button EditUsernameButton = findViewById(R.id.editUsername);
        EditText UserNameEdit = findViewById(R.id.autoCompleteTextView);
        UserNameEdit.setText(app.getUser().getUserName());
        EditUsernameButton.setOnClickListener(v -> editUsername(UserNameEdit.getText().toString()));
        //editPassword
        Button EditPasswordButton = findViewById(R.id.editPassword);
        EditText PasswordEdit = findViewById(R.id.autoCompleteTextView2);
        //PasswordEdit.setText(app.getUser().getPassword());
        EditPasswordButton.setOnClickListener(v -> editPassword(PasswordEdit.getText().toString()));
        //editPhonenumber
        Button EditPNumberButton = findViewById(R.id.editPhonenumber);
        EditText PNumberEdit = findViewById(R.id.autoCompleteTextView3);
        //PNumberEdit.setText(app.getUser().getPhoneNumber());
        EditPNumberButton.setOnClickListener(v -> editPNumber(PNumberEdit.getText().toString()));
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
