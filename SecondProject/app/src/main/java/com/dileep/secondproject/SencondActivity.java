package com.dileep.secondproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SencondActivity extends AppCompatActivity {

    EditText phone,message;
    Button sendBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sencond);
        phone=findViewById(R.id.phone);
        message=findViewById(R.id.message);
        sendBtn=findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.putExtra("address",phone.getText().toString());
                intent.putExtra("sms_body",message.getText().toString());
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);

            }
        });
    }
}