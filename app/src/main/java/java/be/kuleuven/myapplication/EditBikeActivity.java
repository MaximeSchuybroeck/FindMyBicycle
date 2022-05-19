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
        /*
        @SuppressLint("CutPasteId") TextView tv1 = (TextView)findViewById(R.id.bicycle_name);
        tv1.setText(app.getEditBike().getName());
        @SuppressLint("CutPasteId") TextView tv2 = (TextView)findViewById(R.id.editBikeDescription1);
        tv2.setText((app.getEditBike().getDescription()));
        */
        //changeName
        Button EditNameButton = findViewById(R.id.editBikeName);
        @SuppressLint("CutPasteId") EditText NameEdit = findViewById(R.id.bicycle_name);
        EditNameButton.setOnClickListener(v -> changeName(NameEdit.getText().toString()));
        //changeDescription
        Button editDescription = findViewById(R.id.editBikeDescription);
        @SuppressLint("CutPasteId") EditText DescriptionEdit = findViewById(R.id.editBikeDescription1);
        editDescription.setOnClickListener(v -> changeDescription(DescriptionEdit.getText().toString()));
    }
    @SuppressLint("SetTextI18n")
    private void changeName(String name) {
        TextView tv3 = (TextView)findViewById(R.id.actionMessage);
        if(!name.isEmpty() || !name.equals(app.getEditBike().getName())){
            app.getEditBike().setName(name);
            tv3.setText("SUCCEEDED");
        } else{
            tv3.setText("FAILED");
        }
    }
    @SuppressLint("SetTextI18n")
    private void changeDescription(String description) {
        TextView tv3 = (TextView)findViewById(R.id.actionMessage);
        if(!description.isEmpty() || !description.equals(app.getEditBike().getDescription())){
            app.getEditBike().setDescription(description);
            tv3.setText("SUCCEEDED");
        } else{
            tv3.setText("FAILED");
        }
    }
}
