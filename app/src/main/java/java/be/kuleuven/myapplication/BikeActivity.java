package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class BikeActivity extends Activity {
    private UserProfile owner;
    private Bike bike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike);
    }
    public void addBike(View view)
    {
        owner.addBikeList(bike);

    }
}

