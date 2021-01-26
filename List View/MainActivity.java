package com.example.sep2listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView lv1;
ArrayAdapter al1,al2;
Button b1;
  String branches[]={"CSE","ECE","ME","CIVIL"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1=findViewById(R.id.lv1);
        al1=ArrayAdapter.createFromResource(this,
                R.array.subjects, android.R.layout.simple_expandable_list_item_1);
        al2=new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,branches);

        lv1.setAdapter(al1);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),parent.getItemAtPosition(position).toString() , Toast.LENGTH_LONG).show();
            }
        });
        b1=findViewById(R.id.swap);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lv1.getAdapter()==al1){lv1.setAdapter(al2);}
                else{lv1.setAdapter(al1);     }
            }
        });
    }
}
