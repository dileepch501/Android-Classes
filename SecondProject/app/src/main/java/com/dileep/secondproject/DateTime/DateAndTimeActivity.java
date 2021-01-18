package com.dileep.secondproject.DateTime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dileep.secondproject.R;
import com.google.android.material.badge.BadgeUtils;

public class DateAndTimeActivity extends AppCompatActivity {

    Button datePicker,timePicker,digitalAnalog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time);

        datePicker=findViewById(R.id.datePicker);
        timePicker=findViewById(R.id.timePicker);
        digitalAnalog=findViewById(R.id.digitAnalog);


        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dateInten=new Intent(DateAndTimeActivity.this,DateActivity.class);
                startActivity(dateInten);
            }
        });

        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dateInten=new Intent(DateAndTimeActivity.this,TimeActivity.class);
                startActivity(dateInten);

            }
        });
        digitalAnalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dateInten=new Intent(DateAndTimeActivity.this,DigitalAndAnalogActivity.class);
                startActivity(dateInten);
            }
        });

    }
}