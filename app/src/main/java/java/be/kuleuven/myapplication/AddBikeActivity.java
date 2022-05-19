package java.be.kuleuven.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddBikeActivity extends Activity {
    public String bikeName;
    public String description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bike);
        Button addBikeButton = (Button) findViewById(R.id.addBike);
        EditText BikeNameEdit = findViewById(R.id.bikeNameInput);
        EditText DescriptionEdit = findViewById(R.id.descriptionInput);
        addBikeButton.setOnClickListener(v -> addBike(BikeNameEdit.getText().toString(), DescriptionEdit.getText().toString()));
    }
    @SuppressLint("SetTextI18n")
    public void addBike(String bikeName, String description) {
        TextView tv1 = (TextView)findViewById(R.id.actionMessage);
        tv1.setText("SUCCEEDED");
        if (!bikeName.equals("Name")){
            Bike bike = new Bike(bikeName, description);
           app.getUser().addBikeList(bike);
        } else{
            tv1.setText("FAILED");
        }
    }
}