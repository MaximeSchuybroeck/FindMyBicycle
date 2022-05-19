package java.be.kuleuven.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditBikeActivity extends Activity {
    private Bike editBike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        setContentView(R.layout.activity_edit_bike);
        editBike = app.getEditBike();

        //changeName
        Button editNameButton = (Button) findViewById(R.id.editBikeName);
        AutoCompleteTextView nameEdit = findViewById(R.id.bicycle_name);
        //nameEdit.setText(editBike.getName());
        editNameButton.setOnClickListener(v -> changeName(nameEdit.getText().toString()));


        //changeDescription
        Button editDescription = (Button) findViewById(R.id.editBikeDescription);
        AutoCompleteTextView descriptionEdit = findViewById(R.id.editBikeDescription1);
        //nameEdit.setText(editBike.getDescription());
        editDescription.setOnClickListener(v -> changeDescription(descriptionEdit.getText().toString()));
    }
    private void changeName(String name) {
        //TextView tv3 = (TextView)findViewById(R.id.actionMessage);
        if(!name.isEmpty() || !name.equals(app.getEditBike().getName())){
            editBike.setName(name);
            System.out.println(editBike.getName());
            //tv3.setText("SUCCEEDED");
        } else{
            System.out.println("NOOOOOOOOOOOO");
            //tv3.setText("FAILED");
        }
    }
    private void changeDescription(String description) {
        TextView tv3 = (TextView)findViewById(R.id.actionMessage);
        if(!description.isEmpty() || !description.equals(app.getEditBike().getDescription())){
            editBike.setDescription(description);
            System.out.println(editBike.getDescription());
            //tv3.setText("SUCCEEDED");
        } else{
            System.out.println("NOOOOOOOOOOOO");
            //tv3.setText("FAILED");
        }

         */
    }
}
