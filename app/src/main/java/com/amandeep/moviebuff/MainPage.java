package com.amandeep.moviebuff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {
    Button review;
    ImageView three;
    private String name;
    private String email;
    private String mobile;
    private String dob;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage_activity);
        review = findViewById(R.id.rvs);
        three = findViewById(R.id.tolimglast);
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        mobile = intent.getStringExtra("p_usermob");
        name = intent.getStringExtra("p_username");
        dob = intent.getStringExtra("p_userdob");

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, ProfileActivity.class);
                intent.putExtra("m_email", email);
                intent.putExtra("m_mob", mobile);
                intent.putExtra("m_name", name);
                intent.putExtra("m_dob", dob);
                startActivity(intent);
            }
        });

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReviewsPage.class);
                startActivity(intent);

            }
        });
    }
}
