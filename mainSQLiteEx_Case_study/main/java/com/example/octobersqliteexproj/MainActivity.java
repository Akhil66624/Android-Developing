package com.example.octobersqliteexproj;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name1,phn;
    DatabaseHandler db;
    ListView simpleList;
    MyAdapter myAdapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name1=findViewById(R.id.name);
        phn= findViewById(R.id.phn);
        simpleList=findViewById(R.id.listview);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Contact t= myAdapter.getItem(i);
                // Toast.makeText(getApplicationContext(),t.getName()+" selected.",Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(getApplicationContext(),EditList.class);

                intent.putExtra("ID",String.valueOf(t.getID()));
                intent.putExtra("NAME",t.getName());
                intent.putExtra("PHONE",t.getPhoneNumber());

                startActivity(intent);

            }
        });

    }

    public void blick(View view) {

        db = new DatabaseHandler(this);

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        Contact c1=new Contact();
        c1.setName(name1.getText().toString());
        c1.setPhoneNumber(phn.getText().toString());

        db.addContact(c1);
        Toast.makeText(getApplicationContext(),c1.getName()+ " inserted",Toast.LENGTH_LONG).show();   ;

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNumber();
            // Writing Contacts to log
            // Log.d("Name: ", log);
        }

        db.close();
    }

    public void show(View view) {
        db= new DatabaseHandler(this);
        ArrayList<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNumber();
            // Writing Contacts to log

        }



        myAdapter=new MyAdapter(this,R.layout.list_ex,contacts);
        simpleList.setAdapter(myAdapter);
        db.close();

    }
}

class MyAdapter extends ArrayAdapter<Contact> {

    static ArrayList<Contact> phoneList = new ArrayList<Contact>();

    public MyAdapter(Context context, int textViewResourceId, ArrayList<Contact> objects) {
        super(context, textViewResourceId, objects);
        phoneList = objects;
    }

    @Override
    public int getCount() {
        return phoneList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_ex, null);

        TextView textView = v.findViewById(R.id.textView1);
        TextView textView2 =  v.findViewById(R.id.textView2);
        TextView textView0 =  v.findViewById(R.id.textView0);
        textView0.setText(String.valueOf(phoneList.get(position).getID()));
        textView.setText(phoneList.get(position).getName());
        textView2.setText(phoneList.get(position).getPhoneNumber());

        return v;

    }

}