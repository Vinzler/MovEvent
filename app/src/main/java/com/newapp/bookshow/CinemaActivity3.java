package com.newapp.bookshow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CinemaActivity3 extends AppCompatActivity {

    ImageView pvr3,inox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema3);

       pvr3 = (ImageView)findViewById(R.id.pvrcinema3);
        inox3 = (ImageView)findViewById(R.id.inoxcinema3);
        pvr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CinemaActivity3.this,PVRActivity3.class));
            }
        });

        inox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CinemaActivity3.this,InoxActivity3.class));
            }
        });
    }
}
