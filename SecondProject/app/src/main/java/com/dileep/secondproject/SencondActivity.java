package com.dileep.secondproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SencondActivity extends AppCompatActivity {


    Button finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sencond);

        finish=findViewById(R.id.finish1);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finishMsgintent= new Intent();
                finishMsgintent.putExtra("message","Aditya");
                setResult(RESULT_OK,finishMsgintent);

                finish();
            }
        });
    }
}