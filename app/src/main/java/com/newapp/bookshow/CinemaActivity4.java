package com.newapp.bookshow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CinemaActivity4 extends AppCompatActivity {

    ImageView pvr4,inox4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema4);

        pvr4 = (ImageView)findViewById(R.id.pvrcinema4);
        inox4 = (ImageView)findViewById(R.id.inoxcinema4);
        pvr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CinemaActivity4.this,PVRActivity4.class));
            }
        });

        inox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CinemaActivity4.this,InoxActivity4.class));
            }
        });
    }
}
