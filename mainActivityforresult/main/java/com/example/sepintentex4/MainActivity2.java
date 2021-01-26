package com.example.sepintentex4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity2 extends AppCompatActivity {
    TextView tv;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv=findViewById(R.id.textView4);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=getIntent();
                Bundle b=i.getBundleExtra("info");
                int x=b.getInt("First");
                int y=b.getInt("second");
                int res=0;

                String op=b.getString("operation");
                // Toast.makeText(MainActivity2.this,""+x+y+op,Toast.LENGTH_LONG).show();

                switch(op){
                    case "+":  res=x+y ;break;
                    case "-":  res=x-y ;break;
                    case "*":  res=x*y ;break;
                    case "/":  res=x/y;break;
                }
                // tv.setText(String.valueOf(res));

                Intent ri= new Intent();
                ri.putExtra("result",String.valueOf(res));
                setResult(Activity.RESULT_OK,ri);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ri= new Intent();
                ri.putExtra("result",String.valueOf("refused"));

                setResult(Activity.RESULT_CANCELED,ri);
                finish();
            }
        });
    }

}
