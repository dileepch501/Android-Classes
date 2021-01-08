package com.dileep.secondproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SencondActivity extends AppCompatActivity {


    Button submit,alertDialog;
    CheckBox check1,check2,check3;
    RadioGroup radioGroup;
    TextView displayTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sencond);

        submit=findViewById(R.id.finish1);
        check1=findViewById(R.id.ch1);
        check2=findViewById(R.id.ch2);
        check3=findViewById(R.id.ch3);

        radioGroup=findViewById(R.id.radioGroup);
        displayTxt=findViewById(R.id.display);
        alertDialog=findViewById(R.id.alert);



        alertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertBuilder=new AlertDialog.Builder(SencondActivity.this);
                alertBuilder.setMessage("This is alert message")
                        .setCancelable(false)
                        .setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SencondActivity.this, "User clicked Okay button", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SencondActivity.this, "Canceled..", Toast.LENGTH_SHORT).show();
                            }
                        });



                AlertDialog alert=alertBuilder.create();
                alert.show();


            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                displayTxt.setText("");
                String str1="",str2="",str3="";
                String radio="";


                if (check1.isChecked()){
                    str1=check1.getText().toString();
                }
                if (check2.isChecked()){
                    str2=check2.getText().toString();
                }
                if (check3.isChecked()){
                    str3=check3.getText().toString();
                }


                int radioid= radioGroup.getCheckedRadioButtonId();

                if (radioid!=-1) {
                    RadioButton radioButton = findViewById(radioid);
                    radio = radioButton.getText().toString();
                }else {
                    Toast.makeText(SencondActivity.this, "Nothing selected for RadioButton", Toast.LENGTH_SHORT).show();
                }


                displayTxt.setText(str1+"\n"+str2+"\n"+str3+"\n"+radio);

            }
        });
    }
}