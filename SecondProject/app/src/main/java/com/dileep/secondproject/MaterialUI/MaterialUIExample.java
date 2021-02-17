package com.dileep.secondproject.MaterialUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.dileep.secondproject.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MaterialUIExample extends AppCompatActivity {

    TextInputLayout emailLayout,passLayout;
    TextInputEditText emailEdt,passEdt;
    MaterialButton submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_u_i_example);

        emailLayout=findViewById(R.id.emailLayout);
        passLayout=findViewById(R.id.passLayout);

        emailEdt=findViewById(R.id.emailEdt);
        passEdt=findViewById(R.id.passEdt);
        emailLayout.setEndIconVisible(false);
        submit=findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validationEmail() | !validationPass()){
                    return;
                }
                Intent signupIntent=new Intent(MaterialUIExample.this, SignupForm.class);
                startActivity(signupIntent);
//                Toast.makeText(MaterialUIExample.this, "Move to the next screen", Toast.LENGTH_SHORT).show();

            }
        });
        emailLayout.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!emailEdt.getText().toString().isEmpty()){
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

              if (emailEdt.getText().toString().length()!=0) {
                  emailLayout.setEndIconVisible(true);
              }else {
                  emailLayout.setEndIconVisible(false);
              }

          }

          @Override
          public void afterTextChanged(Editable editable) {

          }
      });

    }

    public boolean validationEmail(){

        if (emailEdt.getText().toString().isEmpty()){
            emailLayout.setError("Filed can't be empty");
            return false;
        } else {
            emailLayout.setError(null);
            return true;
        }
    }
    public boolean validationPass(){

        if (passEdt.getText().toString().isEmpty()){
            passLayout.setError("Filed can't be empty");
            return false;
        }else {
            passLayout.setError(null);
            return true;
        }
    }
}