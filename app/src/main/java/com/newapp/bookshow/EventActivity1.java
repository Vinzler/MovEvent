package com.newapp.bookshow;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RatingBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EventActivity1 extends AppCompatActivity {

    String uid;
    private StorageReference mStorage1;
    DatabaseReference reference,reference2,reference3,reference4;
    ImageView im1;
    Button b1,b2;
    Double rat;
    EditText editText1;
    int seatsavailable;
    TextView textView1,textView2;
    FirebaseAuth firebaseAuth1;
    Double current;
    private ArrayList<String> singernames = new ArrayList<>();
    private ArrayList<String> singers = new ArrayList<>();
    private ArrayList<String> textbox = new ArrayList<>();
    RatingBar ratingBar,ratingBar3;
    NumberPicker nopicker1;
    Double ip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event1);

        firebaseAuth1 = FirebaseAuth.getInstance();

        FirebaseUser firebaseUser1 = firebaseAuth1.getCurrentUser();
        uid = firebaseUser1.getUid();

        nopicker1 = (NumberPicker)findViewById(R.id.np1);
        im1 = (ImageView)findViewById(R.id.coldplay);
        b1 = (Button)findViewById(R.id.confirm1);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        ratingBar3 = (RatingBar)findViewById(R.id.ratingBar3);
        textView1 = (TextView)findViewById(R.id.seatavailable);


        mStorage1 = FirebaseStorage.getInstance().getReference();
        reference4 = FirebaseDatabase.getInstance().getReference("Events/Event1/rating");
        reference = FirebaseDatabase.getInstance().getReference("Events/Event1/seatsavailable");
        reference2 = FirebaseDatabase.getInstance().getReference(uid +"/Event/Event1");
        reference3 = FirebaseDatabase.getInstance().getReference(uid+ "/Wallet");

        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/coldplay1.jpg?alt=media&token=97c5ee60-a03e-4733-b40c-a70a4e2469f4").fit().centerCrop().into(im1);


        singernames.add("Chris Martin");
        singernames.add("Guy berryman");
        singernames.add("Will Champion");
        singernames.add("Jonny Buckland");

        singers.add("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/chrismartin.jpg?alt=media&token=680311c1-5747-4fab-80d9-70e88733d75b");
        singers.add("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/guyberryman.jpg?alt=media&token=0a7ec797-0fee-49ab-a03d-98dc54a5b31d");
        singers.add("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/willchampion.jpg?alt=media&token=8d3489cf-ee76-4039-acde-42888a8fbad1");
        singers.add("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/jonnybuckland.jpg?alt=media&token=98d6b8cb-857e-49c1-98b7-6d6b77dd93c4");



        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        final RecyclerView recyclerView = findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(layoutManager);
        final RecyclerViewadapter1 recyclerViewadapter1 = new RecyclerViewadapter1(this,singernames,singers);
        recyclerView.setAdapter(recyclerViewadapter1);

        textbox.add("Coldplay are a British rock band formed in 1996 by lead singer and pianist Chris Martin and lead guitarist Jonny Buckland at University College London ");
        textbox.add("Timing : 6:00 pm");
        textbox.add("Price : Rs. 50/seat");

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        final RecyclerView recyclerView1 = findViewById(R.id.recyclerview3);
        recyclerView1.setLayoutManager(layoutManager1);
        final Recyclerviewadapter2 recyclerViewadapter2 = new Recyclerviewadapter2(this,textbox);
        recyclerView1.setAdapter(recyclerViewadapter2);


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatsavailable = (dataSnapshot.getValue(Double.class)).intValue();
                textView1.setText(" " + seatsavailable);
                nopicker1.setMaxValue(seatsavailable);
                nopicker1.setMinValue(1);
                nopicker1.setWrapSelectorWheel(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ip = dataSnapshot.getValue(Double.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reference4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                rat = dataSnapshot.getValue(Double.class);
                double rat1 = rat;
                float rat2 = (float)rat1;
                ratingBar.setRating(rat2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                current = dataSnapshot.getValue(Double.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double input = Double.valueOf(nopicker1.getValue());
                if(input>seatsavailable){
                    Toast.makeText(getApplicationContext(),"Your input exceeds the number of seats available!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    seatsavailable = seatsavailable-input.intValue();
                    input = input + ip;
                    current = current - input*50;
                    rat = (rat + ratingBar3.getRating())/2;
                 if(current<0)
                 {
                     Toast.makeText(EventActivity1.this,"Insufficient Funds!", Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(EventActivity1.this,NewprofileActivity.class));
                 }
                    reference.setValue(seatsavailable);
                    reference2.setValue(input);
                    reference3.setValue(current);
                    reference4.setValue(rat);
                    startActivity(new Intent(EventActivity1.this,EventConfirm.class));
                }

            }
        });


    }
}
