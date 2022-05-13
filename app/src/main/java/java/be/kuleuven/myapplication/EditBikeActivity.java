package java.be.kuleuven.myapplication;

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
        Button EditNameButton = findViewById(R.id.editBikeName);
        EditText NameEdit = findViewById(R.id.bicycle_name);
        TextView ActionMessage = findViewById(R.id.actionMessage);
        EditNameButton.setOnClickListener(v -> changeName(NameEdit.getText().toString()));
    }

    private void changeName(String name) {
        if(!name.isEmpty()){
            app.getBike().setName(name);
            app.setPopUpTitle("Edit succeeded");
            app.setPopUpMessage("Bicycle name changed to: " + name);
            //PopUp();
            //https://www.youtube.com/watch?v=Bsm-BlXo2SI
        }
    }
}
