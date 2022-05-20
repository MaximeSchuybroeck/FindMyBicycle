package java.be.kuleuven.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class EditBikeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bike);

        //changeName
        Button editNameButton = (Button) findViewById(R.id.editBikeName);
        AutoCompleteTextView nameEdit = findViewById(R.id.bicycle_name);
        nameEdit.setText(App.getEditBike().getName());
        editNameButton.setOnClickListener(v -> changeName(nameEdit.getText().toString()));

        //changeDescription
        Button editDescription = (Button) findViewById(R.id.editBikeDescription);
        AutoCompleteTextView descriptionEdit = findViewById(R.id.editBikeDescription1);
        nameEdit.setText(App.getEditBike().getDescription());
        editDescription.setOnClickListener(v -> changeDescription(descriptionEdit.getText().toString()));
    }
    @SuppressLint("SetTextI18n")
    private void changeName(String name) {
        TextView tv3 = (TextView)findViewById(R.id.actionMessage);
        if(!name.isEmpty() || !name.equals(App.getEditBike().getName())){
            App.getEditBike().setName(name);
            tv3.setText("SUCCEEDED");
        } else{
            tv3.setText("FAILED");
        }
    }
    @SuppressLint("SetTextI18n")
    private void changeDescription(String description) {
        TextView tv3 = (TextView)findViewById(R.id.actionMessage);
        if(!description.isEmpty() || !description.equals(App.getEditBike().getDescription())){
            App.getEditBike().setDescription(description);
            tv3.setText("SUCCEEDED");
        } else{
            tv3.setText("FAILED");
        }

    }
}
