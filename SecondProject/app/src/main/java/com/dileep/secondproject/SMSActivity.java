package com.dileep.secondproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SMSActivity extends AppCompatActivity {

    TextView emailTxt,passwordTxt;
    EditText number,message;
    Button sendBtn,smafinish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_m_s);

        emailTxt=findViewById(R.id.emailTxt);
        passwordTxt=findViewById(R.id.passTxt);
        number=findViewById(R.id.number);
        message=findViewById(R.id.mesage);
        sendBtn=findViewById(R.id.send);
        smafinish=findViewById(R.id.smsFinish);
        Bundle bundle= getIntent().getExtras();

        emailTxt.setText("Email:"+bundle.getString("email"));
        passwordTxt.setText("Password:"+bundle.getString("password"));



        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent=new Intent();

                sendIntent.setAction(Intent.ACTION_VIEW);
                sendIntent.setType("vnd.android-dir/mms-sms");


                sendIntent.putExtra("address",number.getText().toString());
                sendIntent.putExtra("sms_body",message.getText().toString());


                startActivity(sendIntent);

            }
        });


        smafinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finishMsgintent= new Intent();
                finishMsgintent.putExtra("message","Ramji");
                setResult(RESULT_OK,finishMsgintent);
//                startActivity(finishMsgintent);

                finish();
            }
        });


    }
}