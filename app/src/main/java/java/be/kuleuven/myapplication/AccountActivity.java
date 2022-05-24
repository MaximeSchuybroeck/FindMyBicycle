package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

public class AccountActivity extends Activity {
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        TextView userNameEdit = findViewById(R.id.autoCompleteTextView);
        userNameEdit.setText(App.getUser().getUserName());


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
            String requestURL = "https://studev.groept.be/api/a21pt112/updatePhonenumber";
            requestURL += "/" + newPNumber;
            queryMethod(requestURL);

        }
    }

    private void editPassword(String newPassword) {
        if (!newPassword.isEmpty() || !newPassword.equals(App.getUser().getPassword())){
            App.getUser().setPassword(newPassword);
            String requestURL = "https://studev.groept.be/api/a21pt112/updatePassword";
            requestURL += "/" + newPassword;
            queryMethod(requestURL);
        }
    }

    public void queryMethod(String requestURL)
    {
        requestQueue = Volley.newRequestQueue(this);
        requestURL += "/" + App.getUser().getUserName();

        // for testing
        System.out.println(requestURL);

        //query for db
        StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,
                response -> {
                    try {
                        JSONArray responseArray = new JSONArray(response);
                        System.out.println("user edited!");
                        Toast.makeText(this, "user edited!", Toast.LENGTH_SHORT).show();

                    } catch (JSONException e) {
                        Log.e("database", e.getMessage(), e);
                    }
                },
                error -> System.out.println(error.getLocalizedMessage()));
        requestQueue.add(submitRequest);
    }

}
