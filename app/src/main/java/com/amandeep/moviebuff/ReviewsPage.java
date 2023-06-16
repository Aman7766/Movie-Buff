package com.amandeep.moviebuff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReviewsPage extends AppCompatActivity {
    ImageView img;
    ImageView three;
    ListView lst;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews_page);
        img = findViewById(R.id.hamburg);
        three = findViewById(R.id.tolimglast);
        lst = findViewById(R.id.lst);
        String[] data = {"First Review", "Second Review", "Third Review", "Fourth Review", "Fifth Review"};

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.list_item, R.id.textView, data);
        lst.setAdapter(arrayAdapter);

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewsPage.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewsPage.this, MainPage.class);
                startActivity(intent);
            }
        });
    }
}
