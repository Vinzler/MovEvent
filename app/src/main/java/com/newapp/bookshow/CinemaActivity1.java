package com.newapp.bookshow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CinemaActivity1 extends AppCompatActivity {

    ImageView inox,pvr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema1);

        inox = (ImageView)findViewById(R.id.inoxcinema1);
        pvr = (ImageView)findViewById(R.id.pvrcinema1);

        inox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(CinemaActivity1.this,InoxActivity.class));
            }
        });

        pvr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CinemaActivity1.this,PVRActivity.class));
            }
        });
    }
}
