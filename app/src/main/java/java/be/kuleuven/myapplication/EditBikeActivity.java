package java.be.kuleuven.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditBikeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bike);
        //changeName
        Button EditNameButton = findViewById(R.id.editBikeName);
        EditText NameEdit = findViewById(R.id.bicycle_name);
        EditNameButton.setOnClickListener(v -> changeName(NameEdit.getText().toString()));
        //changeDescription
        Button editDescription = findViewById(R.id.editBikeDescription);
        EditText DescriptionEdit = findViewById(R.id.editBikeDescription1);
        editDescription.setOnClickListener(v -> changeDescription(DescriptionEdit.getText().toString()));
    }

    @SuppressLint("SetTextI18n")
    private void changeName(String name) {
        TextView tv1 = (TextView)findViewById(R.id.actionMessage);
        if(!name.isEmpty() || !name.equals(app.getEditBike().getName())){
            app.getEditBike().setName(name);
            tv1.setText("SUCCEEDED");
            setContentView(tv1);
        } else{
            tv1.setText("FAILED");
            setContentView(tv1);
        }
    }
    private void changeDescription(String description) {
        if(!description.isEmpty() || !description.equals(app.getEditBike().getDescription())){
            app.getEditBike().setDescription(description);
            app.setPopUpTitle("Edit succeeded");
            app.setPopUpMessage("Description changed to: " + description);
        } else{
            app.setPopUpTitle("EDIT FAILED");
            app.setPopUpMessage("Give a useful description, and not: " + description);
        }
        new PopUp();
    }
}
