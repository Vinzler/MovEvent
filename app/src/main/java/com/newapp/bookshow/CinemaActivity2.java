package com.newapp.bookshow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CinemaActivity2 extends AppCompatActivity {

    ImageView inox2,pvr2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema2);

        pvr2 = (ImageView) findViewById(R.id.pvrcinema2);
        inox2 = (ImageView) findViewById(R.id.inoxcinema2);

        pvr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CinemaActivity2.this,PVRActivity2.class));
            }
        });

        inox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CinemaActivity2.this,InoxActivity2.class));
            }
        });
    }
}
