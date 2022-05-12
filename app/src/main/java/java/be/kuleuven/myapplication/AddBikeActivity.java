package java.be.kuleuven.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddBikeActivity extends AppCompatActivity {
    public String bikeName;
    public String description;
    public UserProfile userProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bike);
        Button addBikeButton = (Button) findViewById(R.id.addBike);
        addBikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    //register a new bike if bike has a name, can have a description
                    if (bikeName != null)// still needs to retrieve this information from the text fields
                    {
                        if (description != null)
                        {
                            addBike(bikeName, description);
                        }
                        else
                        {
                            addBike(bikeName);
                        }
                    }
                }
            }
        });
    }
    public void addBike(String bikeName, String description)
    {
        Bike bike = new Bike(bikeName, description);
        userProfile.addBikeList(bike);
        //userProfile.getBikeList();
    }

    public void addBike(String bikeName)
    {
        Bike bike = new Bike(bikeName);
        userProfile.addBikeList(bike);
        //userProfile.getBikeList();
    }
}