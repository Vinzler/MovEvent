package com.newapp.bookshow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class MovieActivity extends AppCompatActivity {

    Button bck;
    private ImageView mImageView,mImageView1,mImageView2,mImageView3;
    TextView now;
    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        mStorageRef = FirebaseStorage.getInstance().getReference();

        mImageView = (ImageView)findViewById(R.id.image_view1);
        mImageView1 = (ImageView)findViewById(R.id.image_view);
        mImageView2 = (ImageView)findViewById(R.id.image_view2);
        mImageView3 = (ImageView)findViewById(R.id.image_view3);

       // final String url = "https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/Imitationgame.jpg?alt=media&token=11b7b8f6-5a63-44ad-a664-185d3112318c";
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/Imitationgame.jpg?alt=media&token=11b7b8f6-5a63-44ad-a664-185d3112318c").fit().centerCrop().into(mImageView1);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/BeautifulMind.jpg?alt=media&token=e0308f9f-79b7-4379-9c1a-d656b0cfe156").fit().centerCrop().into(mImageView2);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/Tron.jpg?alt=media&token=d880334e-5d18-4b23-94d9-638d5608f020").fit().centerCrop().into(mImageView3);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/Venom.jpg?alt=media&token=cf21f77e-c888-48ac-8462-b1486f804d2d").fit().centerCrop().into(mImageView);




        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(MovieActivity.this,CinemaActivity1.class));
            }
        });

        mImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(MovieActivity.this,CinemaActivity2.class));
            }
        });

        mImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(MovieActivity.this,CinemaActivity3.class));
            }
        });

        mImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(MovieActivity.this,CinemaActivity4.class));
            }
        });
    }
}
