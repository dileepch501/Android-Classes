package com.dileep.secondproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ClassSixDemo extends AppCompatActivity {

    Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_six_demo);
        submitBtn=findViewById(R.id.submit);




        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ClassSixDemo.this,"Button clicked",Toast.LENGTH_LONG).show();

//                Intent startIntent = new Intent(ClassSixDemo.this,SMSActivity.class);
//
//                startActivity(startIntent);

            }
        });


    }
}