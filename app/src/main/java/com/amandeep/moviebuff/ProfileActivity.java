package com.amandeep.moviebuff;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.amandeep.moviebuff.db.DBHelper;

public class ProfileActivity extends AppCompatActivity {
    ImageView img;
    DBHelper dbHelper;
    EditText name, email, mobile, dob;
    Button btn;
    String PEmail;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilepage_activity);
        img = findViewById(R.id.hamburg);
        dbHelper = new DBHelper(getApplicationContext());
        name = findViewById(R.id.nameedt);
        mobile = findViewById(R.id.conedt);
        email = findViewById(R.id.emailedt);
        dob = findViewById(R.id.dobedt);
        btn = findViewById(R.id.prf_btn);
        email.setEnabled(false);
        Intent intent = getIntent();
        PEmail = intent.getStringExtra("email");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ValidateName() && ValidateContact() && ValiateDob()) {
                    String nameedt = name.getText().toString();
                    String cn = mobile.getText().toString();
                    String em = email.getText().toString();
                    String db = dob.getText().toString();
                    if (dbHelper.UpdateData(nameedt, cn, em, db)) {
                        Log.d("Update", "updated succesfuly");
                    }
                }
            }
        });


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainPage.class);
                startActivity(intent);
            }
        });
        ViewData();

    }

    public void ViewData() {
        Cursor data = dbHelper.ViewData(PEmail);
        if (data.moveToFirst()) {
            name.setText(data.getString(0));
            mobile.setText(data.getString(1));
            email.setText(data.getString(2));
        }
    }

    public boolean ValidateName() {
        String data = name.getText().toString();
        if (data.isEmpty()) {
            name.setError("Name is required");
            return false;
        } else if (data.length() > 50) {
            name.setError("Name is too long");
            return false;
        } else if (!data.matches("[a-zA-Z ]+")) {
            name.setError("Invalid Name");
            return false;
        } else {
            name.setError(null);
            return true;
        }

    }

    public boolean ValidateContact() {
        String cn = mobile.getText().toString();
        if (cn.isEmpty()) {
            mobile.setError("Mobile is required");
            return false;
        } else if (!cn.matches("[0-9]{10}")) {
            mobile.setError("Only 10 digit required");
            return false;
        } else {
            mobile.setError(null);
            return true;
        }
    }


    public boolean ValiateDob() {
        String dobData = dob.getText().toString();
        if (dobData.isEmpty()) {
            dob.setError("DOB is required");
            return false;
        } else {
            dob.setError(null);
            return true;
        }
    }
}
