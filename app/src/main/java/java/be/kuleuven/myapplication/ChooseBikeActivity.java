package java.be.kuleuven.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class ChooseBikeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_bike);
        Spinner spinner = findViewById(R.id.choose_bike_dropdown_menu);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.chooseBikeDropdown, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button goNext = findViewById(R.id.button2);
        goNext.setOnClickListener(v -> goNextActivity());

    }

    public void goNextActivity() {
        Intent intent;
        if(App.getChooseBikeNextActivity().equals("edit")){
            intent = new Intent(this, EditBikeActivity.class);
        } else{
            intent = new Intent(this, LocationActivity2.class);
        }
        startActivity(intent);


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        char number = parent.getItemAtPosition(position).toString().charAt(4);

        for (int i = 0; i < App.getUser().getBikeList().size(); i++)
        {

            if (App.getUser().getBikeList().get(i).getNumber().charAt(0) == (number))
            {
                App.setEditBike(App.getUser().getBikeList().get(i));
            }
        }
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}