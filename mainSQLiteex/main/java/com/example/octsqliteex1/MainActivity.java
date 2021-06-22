package com.example.octsqliteex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etFirstName,etLastName,etPhone,etEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase database = openOrCreateDatabase("contacts.db", this.MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS Contact(first_name TEXT, last_name TEXT, phone TEXT PRIMARY KEY, email TEXT);");
        database.close();
        etFirstName=findViewById(R.id.etFirstName);
        etLastName=findViewById(R.id.etLastName);
        etPhone=findViewById(R.id.etPhone);
        etEmail=findViewById(R.id.etEmail);
    }

    public void insert(View v)
    {
        SQLiteDatabase database1 = openOrCreateDatabase("contacts.db", this.MODE_PRIVATE, null);
        ContentValues values = new ContentValues();
        values.put("first_name", etFirstName.getText().toString());
        values.put("last_name", etLastName.getText().toString());
        values.put("phone", etPhone.getText().toString());
        values.put("email", etEmail.getText().toString());
        database1.insert("Contact", null, values);
        database1.close();
        this.finish();
    }
}
