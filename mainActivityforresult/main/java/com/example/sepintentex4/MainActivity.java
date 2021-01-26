package com.example.sepintentex4;



import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    RadioGroup rg1;
    RadioButton rb[]= new RadioButton[4];
    EditText et1,et2;
    TextView tv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= findViewById(R.id.button);
        et1=findViewById(R.id.editText2);
        et2=findViewById(R.id.editText3);
        rg1=findViewById(R.id.radioGroup);
        rb[0]=findViewById(R.id.radioButton);
        rb[1]=findViewById(R.id.radioButton2);
        rb[2]=findViewById(R.id.radioButton3);
        rb[3]=findViewById(R.id.radioButton4);
        tv5=findViewById(R.id.textView5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,MainActivity2.class);
                Bundle b = new Bundle();

                int x = Integer.parseInt(et1.getText().toString());
                int y = Integer.parseInt(et2.getText().toString());

                if(rg1.getCheckedRadioButtonId()==R.id.radioButton)
                {
                    b.putString("operation","+");
                }
                else if(rg1.getCheckedRadioButtonId()==R.id.radioButton2)
                {
                    b.putString("operation","-");
                }
                else if(rg1.getCheckedRadioButtonId()==R.id.radioButton3)
                {
                    b.putString("operation","*");
                }
                else if(rg1.getCheckedRadioButtonId()==R.id.radioButton4)
                {
                    b.putString("operation","/");
                }
                //Toast.makeText(MainActivity.this," hh"+b.getString("operation"),Toast.LENGTH_LONG).show();
                b.putInt("First",x);
                b.putInt("second",y);

                i.putExtra("info",b);



                startActivityForResult(i,8);


            }
        });

    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==8)
        {
            if(resultCode== Activity.RESULT_OK)
            {
                tv5.setText(data.getStringExtra("result"));
            }
            else
            {
                tv5.setText("no result");

            }
        }
    }
}
