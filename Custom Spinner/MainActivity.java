package com.example.aug27spinnerex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity   implements AdapterView.OnItemSelectedListener {
    String[] country = { "India", "USA", "China", "Japan", "Other"};
    Spinner sp1,sp2,sp3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp1=findViewById(R.id.spin1);
        sp2=findViewById(R.id.spin2);
        sp3=findViewById(R.id.spin3);
        sp2.setOnItemSelectedListener(this);
        ArrayAdapter aa2 = ArrayAdapter.createFromResource(this,
                R.array.planets, android.R.layout.simple_spinner_dropdown_item);//android.R.layout.

        aa2.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
        sp2.setAdapter(aa2); sp2.setSelection(3);

        ArrayAdapter aa = new ArrayAdapter(this,R.layout.spin1,R.id.tv1,country);

        sp1.setAdapter(aa);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),parent.getItemAtPosition(position).toString() , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),parent.getItemAtPosition(position).toString()
                , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
