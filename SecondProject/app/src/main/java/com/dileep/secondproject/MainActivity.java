package com.dileep.secondproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dileep.secondproject.ListViewPackage.ActivityList;
import com.dileep.secondproject.RatingBarsPackage.RatingBarExample;

public class MainActivity extends AppCompatActivity {
    TextView returnMsg;
    Button nextRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.passwrod);

        Button login = findViewById(R.id.loginBtn);
        TextView loginTxt = findViewById(R.id.logintxt);
        Button nextBtn = findViewById(R.id.nextBtn);
        returnMsg = findViewById(R.id.returnMsg);
        nextRating = findViewById(R.id.ratingBtn);


        nextRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ratingintent = new Intent(MainActivity.this, SignupPage.class);
                startActivity(ratingintent);
            }
        });


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondIntent = new Intent(MainActivity.this, ActivityList.class);
                startActivityForResult(secondIntent, 103);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                Intent intentObjec=new Intent(MainActivity.this,SMSActivity.class);
//
//                intentObjec.putExtra("email",email.getText().toString());
//                intentObjec.putExtra("password",password.getText().toString());
//
////               startActivity(intentObjec);
//                startActivityForResult(intentObjec,101);

                SharedPreferences preferences = getSharedPreferences("androidClasses", MODE_PRIVATE);

                String savedUserName = preferences.getString("userName", "");
                String savedPassword = preferences.getString("passWord", "");


                if (email.getText().toString().equals(savedUserName)) {
                    if (password.getText().toString().equals(savedPassword)) {
                        Intent intentObjec = new Intent(MainActivity.this, SMSActivity.class);
                        intentObjec.putExtra("email", email.getText().toString());
                        intentObjec.putExtra("password", password.getText().toString());

               startActivity(intentObjec);
//                        startActivityForResult(intentObjec, 101);
                    }else {
                        Toast.makeText(MainActivity.this, "Password was not matched", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "User name not matched", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 101) {
//            returnMsg.setText(data.getStringExtra("message").toString());
//        } else if (requestCode == 102) {
//            returnMsg.setText(data.getStringExtra("message").toString());
//        }
//
//    }
}