package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
    public void addBike(String bikeName, String description) {
        if (!bikeName.equals("Name")){
            Bike bike = new Bike(bikeName, description);
            app.getUser().addBikeList(bike);
            app.setPopUpTitle("SUCCEEDED!");
            app.setPopUpMessage("Bicycle added: " + bikeName);
            new PopUp();
            Intent intent = new Intent(this, BikeActivity.class);
            startActivity(intent);
        } else{
            app.setPopUpTitle("FAILED");
            app.setPopUpMessage("Give a useful name, and not: " + bikeName);
            new PopUp();
        }
    }
}