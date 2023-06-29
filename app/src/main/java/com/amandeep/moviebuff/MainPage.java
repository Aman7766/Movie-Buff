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
    String GEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage_activity);
        review = findViewById(R.id.rvs);
        three = findViewById(R.id.tolimglast);
        Intent intent = getIntent();
        GEmail = intent.getStringExtra("email");
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, ProfileActivity.class);
                intent.putExtra("email", GEmail);
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
