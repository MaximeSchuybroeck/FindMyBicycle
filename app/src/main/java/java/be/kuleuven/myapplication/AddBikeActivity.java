package java.be.kuleuven.myapplication;

import android.app.Activity;
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
        Bike bike = new Bike(bikeName, description);
        userProfile.addBikeList(bike);
        //popup ding
        //userProfile.getBikeList();
    }

    public void addBike(String bikeName) {
        Bike bike = new Bike(bikeName);
        userProfile.addBikeList(bike);
        System.out.println("numer 2");
        //userProfile.getBikeList();
    }

    /*
    {
            {
                //register a new bike if bike has a name, can have a description
                if (!bikeName.equals("Name"))// still needs to retrieve this information from the text fields
                {
                    if (!description.equals("Optional") ) {
                        addBike(bikeName, description);
                    }else {
                        addBike(bikeName);
                    } } } }
     */
}