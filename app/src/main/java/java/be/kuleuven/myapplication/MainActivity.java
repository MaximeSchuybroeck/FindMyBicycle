package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button manageBikeButton = (Button) findViewById(R.id.ManageBike);
        manageBikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBikeActivity();
            }
        });

        Button manageLocationButton = (Button) findViewById(R.id.ManageLocations);
        manageBikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLocationActivity();
            }
        });

        Button manageAccountButton = (Button) findViewById(R.id.ManageAccount);
        manageAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goAccountActivity();
            }
        });
    }
    public void goBikeActivity()
    {
        Intent intent = new Intent(this, BikeActivity.class);
        startActivity(intent);
    }

    public void goLocationActivity()
    {
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }

    public void goAccountActivity()
    {
        Intent intent = new Intent (this, AccountActivity.class);
        startActivity(intent);
    }
}
