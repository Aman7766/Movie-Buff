package com.amandeep.moviebuff;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.amandeep.moviebuff.db.DBHelper;
import com.google.android.material.textfield.TextInputLayout;

public class SignupActivity extends AppCompatActivity {
    TextView bottom_login;
    TextInputLayout nameLayout, mobLayout, emailLayout, passLayout;
    //    EditText mobile;
//    EditText email;
//    EditText password;
    Button button;

    DBHelper dbHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        bottom_login = findViewById(R.id.signup_bottom);
        nameLayout = findViewById(R.id.s_nl);
        mobLayout = findViewById(R.id.s_mob);
        emailLayout = findViewById(R.id.s_email);
   

        passLayout = findViewById(R.id.s_pass);
        dbHelper = new DBHelper(SignupActivity.this);
//        email=findViewById(R.id.s_email);
//        mobile=findViewById(R.id.s_mob);
//        password=findViewById(R.id.s_pass);
        button = findViewById(R.id.S_signup);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateName() && validateMobile() && validateEmail() && validatePassword()) {
                    String name = nameLayout.getEditText().getText().toString();
                    String mobile = mobLayout.getEditText().getText().toString();
                    String email = emailLayout.getEditText().getText().toString();
                    String password = passLayout.getEditText().getText().toString();
                    boolean isInserterd = dbHelper.addData(name, mobile, email, password);
                    if (isInserterd) {
                        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                        startActivity(intent);
                        Log.d("SignupActivity", "Signup Done");
                    } else {
                        Log.d("SignupActivity", "Signup failed");
                    }

                }
            }
        });


        bottom_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void registerUser() {
        validateName();
    }

    public boolean validateName() {
        String val = nameLayout.getEditText().getText().toString();
        if (val.isEmpty()) {
            nameLayout.setError("Name is required");
            return false;
        } else if (val.length() > 50) {
            nameLayout.setError("Name too long");
            return false;
        } else if (!val.matches("[a-zA-Z]+")) {
            nameLayout.setError("Invalid name");
            return false;
        } else {
            nameLayout.setError(null);
            nameLayout.setErrorEnabled(false);
            return true;
        }
    }

    public boolean validateMobile() {
        String val = mobLayout.getEditText().getText().toString();
        if (val.isEmpty()) {
            mobLayout.setError("Mobile is required");
            return false;
        } else if (!val.matches("[0-9]{10}")) {
            {
                mobLayout.setError("Only 10 digit required");
                return true;
            }

        } else {
            mobLayout.setError(null);
            mobLayout.setErrorEnabled(false);
            return true;
        }
    }

    public boolean validateEmail() {
        String val = emailLayout.getEditText().getText().toString();
        if (val.isEmpty()) {
            emailLayout.setError("Email is required");
            return false;
        } else if (!val.matches("[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.]([a-zA-Z]+))+")) {
            emailLayout.setError("Email is invalid");
            return false;
        } else {
            emailLayout.setError(null);
            emailLayout.setErrorEnabled(false);
            return true;
        }
    }

    public boolean validatePassword() {
        String val = passLayout.getEditText().getText().toString();
        if (val.isEmpty()) {
            passLayout.setError("Password is required");
            return false;
        } else {
            passLayout.setError(null);
            passLayout.setErrorEnabled(false);
            return true;
        }
    }


}
