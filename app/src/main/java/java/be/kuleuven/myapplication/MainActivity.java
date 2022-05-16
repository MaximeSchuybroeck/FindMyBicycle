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
        //manage bike
        Button manageBikeButton = findViewById(R.id.ManageBike);
        manageBikeButton.setOnClickListener(v -> goBikeActivity());
        //manage account
        Button manageAccountButton = findViewById(R.id.ManageAccount);
        manageAccountButton.setOnClickListener(v -> goAccountActivity());
    }
    public void goBikeActivity(){
        Intent intent = new Intent(this, BikeActivity.class);
        startActivity(intent);
    }

    public void goAccountActivity(){
        Intent intent = new Intent (this, AccountActivity.class);
        startActivity(intent);
    }
}
