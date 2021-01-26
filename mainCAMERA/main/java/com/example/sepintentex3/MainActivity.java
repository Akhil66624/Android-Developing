package com.example.sepintentex3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
        Button b;
        ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        iv=findViewById(R.id.imageView);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ci= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(ci,500);
            }
        });
    }
    protected  void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==500 && resultCode== Activity.RESULT_OK)
        {
            Bitmap photo=(Bitmap) data.getExtras().get("data");
            iv.setImageBitmap(photo);
        }


    }
}
