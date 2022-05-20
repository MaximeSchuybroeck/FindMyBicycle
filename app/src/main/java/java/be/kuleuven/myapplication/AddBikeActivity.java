package java.be.kuleuven.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddBikeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bike);
        Button addBikeButton = (Button) findViewById(R.id.addBike);
        EditText bikeNameEdit = findViewById(R.id.bikeNameInput);
        EditText descriptionEdit = findViewById(R.id.descriptionInput);
        addBikeButton.setOnClickListener(v -> addBike(bikeNameEdit.getText().toString(), descriptionEdit.getText().toString()));
    }
    @SuppressLint("SetTextI18n")
    public void addBike(String bikeName, String description) {
        TextView tv1 = (TextView)findViewById(R.id.actionMessage);
        if (!bikeName.equals("Name") || !(App.getUser().isMemberBikeList(bikeName))) {
            tv1.setText("SUCCEEDED");
            App.getUser().addStringBikeList(bikeName, description);
            // TODO: 19/05/2022 addbikelist probleem
        } else{
            tv1.setText("FAILED");
        }
    }
}