package com.dileep.secondproject.MaterialUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dileep.secondproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.BufferedReader;

public class SignupForm extends AppCompatActivity {


    TextInputEditText emailEdt, passEdt;
    Button submit;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);
        emailEdt=findViewById(R.id.emailEdt);
        passEdt=findViewById(R.id.passEdt);

        submit=findViewById(R.id.submit);

        firebaseAuth=FirebaseAuth.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog=new ProgressDialog(SignupForm.this);
                progressDialog.setMessage("Please wait...");
                progressDialog.show();

                String emailStr=emailEdt.getText().toString().trim();
                String passStr=passEdt.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(emailStr,passStr)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(SignupForm.this, "Signup success", Toast.LENGTH_SHORT).show();
                                    Intent loginintent=new Intent(SignupForm.this,MaterialUIExample.class);
                                    startActivity(loginintent);
                                    finish();
                                }else {
                                    Toast.makeText(SignupForm.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                                progressDialog.dismiss();
                            }
                        });


            }
        });


    }
}