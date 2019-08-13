package com.newapp.bookshow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EventConfirm extends AppCompatActivity {

    Button finback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_confirm);

        finback = (Button)findViewById(R.id.finalback);
        finback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventConfirm.this,NewprofileActivity.class));
            }
        });
    }
}
