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

        //changeDescription
        Button editDescription = (Button) findViewById(R.id.editBikeDescription);
        AutoCompleteTextView descriptionEdit = findViewById(R.id.bicycle_description);
        descriptionEdit.setText(App.getEditBike().getDescription());
        editDescription.setOnClickListener(v -> changeDescription(descriptionEdit.getText().toString()));
    }

    @SuppressLint("SetTextI18n")
    private void changeDescription(String description) {
        TextView tv3 = (TextView)findViewById(R.id.actionMessage);
        if(!description.isEmpty() && !description.equals(App.getEditBike().getDescription())){
            App.getEditBike().setDescription(description);
            tv3.setText("SUCCEEDED");
        } else{
            tv3.setText("FAILED");
        }

    }
}
