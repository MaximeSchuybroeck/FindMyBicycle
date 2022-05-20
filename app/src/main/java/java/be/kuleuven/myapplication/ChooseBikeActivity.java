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


import java.util.ArrayList;


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

    public void goNextActivity()
    {
        Intent intent = new Intent(this, EditBikeActivity2.class);
        startActivity(intent);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        ///Hier zit nog een fout in want rest werkt
        System.out.println("test1");
        for (int i = 0; i < app.getUser().getBikeList().size(); i++)
        {
            System.out.println("test2");
            if (app.getUser().getBikeList().get(i).getName().equals(text))
            {
                app.setEditBike(app.getUser().getBikeList().get(i));
                System.out.println("test3");
            }
        }
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}