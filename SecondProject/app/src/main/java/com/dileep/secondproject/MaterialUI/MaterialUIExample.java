package com.dileep.secondproject.MaterialUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dileep.secondproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MaterialUIExample extends AppCompatActivity {

    TextInputLayout emailLayout, passLayout;
    TextInputEditText emailEdt, passEdt;
    MaterialButton submit;
    private FirebaseAuth mAuth;
    ProgressDialog progressDialog;
    TextView createAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_u_i_example);
        mAuth = FirebaseAuth.getInstance(); // getting instance of the firebaseAuth
        emailLayout = findViewById(R.id.emailLayout);
        passLayout = findViewById(R.id.passLayout);

        emailEdt = findViewById(R.id.emailEdt);
        passEdt = findViewById(R.id.passEdt);
        emailLayout.setEndIconVisible(false);
        submit = findViewById(R.id.submit);
        createAct = findViewById(R.id.creatAct);


        createAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupintent = new Intent(MaterialUIExample.this, SignupForm.class);
                startActivity(signupintent);
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validationEmail() | !validationPass()) {
                    return;
                }

                signInMethod();
//                Intent signupIntent=new Intent(MaterialUIExample.this, SignupForm.class);
//                startActivity(signupIntent);
//                Toast.makeText(MaterialUIExample.this, "Move to the next screen", Toast.LENGTH_SHORT).show();

            }
        });
        emailLayout.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!emailEdt.getText().toString().isEmpty()) {
                    emailEdt.setText("");
                }
            }
        });

        emailEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (emailEdt.getText().toString().length() != 0) {
                    emailLayout.setEndIconVisible(true);
                } else {
                    emailLayout.setEndIconVisible(false);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser!=null){
            Intent signupIntent = new Intent(MaterialUIExample.this, HomeActivity.class);
            startActivity(signupIntent);
            finish();
        }
//        updateUI(currentUser);
    }

    public void signInMethod() {
        progressDialog = new ProgressDialog(MaterialUIExample.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        String userName = emailEdt.getText().toString().trim();
        String password = passEdt.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
//                    Toast.makeText(MaterialUIExample.this, "Login success", Toast.LENGTH_SHORT).show();
                    Intent signupIntent = new Intent(MaterialUIExample.this, HomeActivity.class);
                    startActivity(signupIntent);
                    finish();
                } else {
                    Toast.makeText(MaterialUIExample.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });

    }

    public boolean validationEmail() {

        if (emailEdt.getText().toString().isEmpty()) {
            emailLayout.setError("Filed can't be empty");
            return false;
        } else {
            emailLayout.setError(null);
            return true;
        }
    }

    public boolean validationPass() {

        if (passEdt.getText().toString().isEmpty()) {
            passLayout.setError("Filed can't be empty");
            return false;
        } else {
            passLayout.setError(null);
            return true;
        }
    }
}