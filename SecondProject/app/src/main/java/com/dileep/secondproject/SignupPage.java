package com.dileep.secondproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupPage extends AppCompatActivity {

    EditText nameEdt,passwordEdt;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        nameEdt=findViewById(R.id.email);
        passwordEdt=findViewById(R.id.passwrod);
        signup=findViewById(R.id.submit);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUserName= nameEdt.getText().toString();
                String enteredPassword= passwordEdt.getText().toString();

                SharedPreferences  preferences =getSharedPreferences("androidClasses",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();

                editor.putString("userName",enteredUserName);
                editor.putString("passWord",enteredPassword);

                editor.apply();

                Toast.makeText(SignupPage.this, "SignUp success", Toast.LENGTH_SHORT).show();

            }
        });


    }
}