package com.dileep.secondproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SencondActivity extends AppCompatActivity {


    Button submit,alertDialog;
    CheckBox check1,check2,check3;
    RadioGroup radioGroup;
    TextView displayTxt;

    Spinner spinner,spinner2;

    ArrayList<String> spinnerArrayList=new ArrayList<>();


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
        spinner=findViewById(R.id.spinner);
        spinner2=findViewById(R.id.spinner2);

        spinnerArrayList.add("list 1");
        spinnerArrayList.add("list 2");
        spinnerArrayList.add("list 3");
        spinnerArrayList.add("list 4");
        spinnerArrayList.add("list 5");
        spinnerArrayList.add("list 6");

        String [] arrayList={"array1","array2","array3","array4"};


        ArrayAdapter arrayAdapter=new ArrayAdapter(this, R.layout.spinner_list_item, arrayList);
       spinner.setAdapter(arrayAdapter);

        ArrayAdapter arrayAdapter2=new ArrayAdapter(this, R.layout.spinner_list_item, spinnerArrayList);
       spinner2.setAdapter(arrayAdapter2);

       String seletedItem=spinner.getSelectedItem().toString();
        String seletedItem2=spinner2.getSelectedItem().toString();
        Toast.makeText(this, seletedItem+"  "+seletedItem2, Toast.LENGTH_SHORT).show();

       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               String seletedItem=spinner.getSelectedItem().toString();
               String seletedItem2=spinner2.getSelectedItem().toString();
               Log.e("SpinnerItems",seletedItem+seletedItem2);
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });



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