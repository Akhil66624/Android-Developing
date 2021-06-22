package com.example.octobersqliteexproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditList extends AppCompatActivity {
    EditText id,name,phn;
    DatabaseHandler db; Contact contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);
        id=findViewById(R.id.editText);
        name=findViewById(R.id.editText2);
        phn=findViewById(R.id.editText3);
        db = new DatabaseHandler(this);
        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("ID");
        String value2 = extras.getString("NAME");
        String value3 = extras.getString("PHONE");
        id.setText(value1); name.setText(value2);phn.setText(value3);

    }

    public void goBack(View view) {

        if(view.getId()==R.id.button2) {


            contact= new Contact(Integer.parseInt(id.getText().toString()),name.getText().toString(),phn.getText().toString());

            db.updateContact(contact);
            Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();

        }
        else{}

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);

    }
}
