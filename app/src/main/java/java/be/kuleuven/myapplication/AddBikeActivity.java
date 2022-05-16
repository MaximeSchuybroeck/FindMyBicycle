package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class AddBikeActivity extends Activity {
    public String bikeName;
    public String description;
    public UserProfile userProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bike);
        Button addBikeButton = (Button) findViewById(R.id.addBike);
        addBikeButton.setOnClickListener(v -> {
            {
                //register a new bike if bike has a name, can have a description
                if (bikeName != null)// still needs to retrieve this information from the text fields
                {
                    if (description != null) {
                        addBike(bikeName, description);
                    }else {
                        addBike(bikeName);
                    } } } });
    }
    public void addBike(String bikeName, String description) {
        Bike bike = new Bike(bikeName, description);
        userProfile.addBikeList(bike);
        //userProfile.getBikeList();
    }

    public void addBike(String bikeName) {
        Bike bike = new Bike(bikeName);
        userProfile.addBikeList(bike);
        //userProfile.getBikeList();
    }
}