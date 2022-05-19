package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class EditBikeActivity2 extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bike);
        Bike editBike = app.getEditBike();
        System.out.println(editBike.getName());
        System.out.println("######################################");

        //change description
        Button editNameButton = (Button) findViewById(R.id.editBikeName);
        EditText nameText = (EditText) findViewById(R.id.bicycle_name);
        editNameButton.setOnClickListener(v -> changeDescription(String.valueOf(nameText.getText()), editBike));


    }

    private void changeDescription(String description, Bike editBike) {
        editBike.setDescription(description);
        System.out.println("SUCCESSSSSS!!!!!!");


    }
}
