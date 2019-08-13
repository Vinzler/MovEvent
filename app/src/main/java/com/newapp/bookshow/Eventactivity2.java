package com.newapp.bookshow;

import android.content.Intent;
import android.support.annotation.NonNull;
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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Eventactivity2 extends AppCompatActivity {
    private StorageReference storageReference2;
   private FirebaseAuth firebaseAuth2;
   String uid2;
   TextView tv14;
   Double rate,rate1;
   TextView t1;
   ImageView im2;
   NumberPicker np2;
   RatingBar ratingBar,ratingBar3;
   int seatsavaialable2;
   Double ip;
   Double current2;
   Button b2,c2;
    DatabaseReference refer1,refer2,refer3,refer4;
    private ArrayList<String> singernames = new ArrayList<>();
    private ArrayList<String> singers = new ArrayList<>();

    private ArrayList<String> textbox = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventactivity2);

        firebaseAuth2 = FirebaseAuth.getInstance();

        FirebaseUser firebaseUser = firebaseAuth2.getCurrentUser();
        uid2 = firebaseUser.getUid();

        storageReference2 = FirebaseStorage.getInstance().getReference();
      im2 = (ImageView)findViewById(R.id.maroonv);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar2);
      c2 = (Button)findViewById(R.id.c2);
      np2 = (NumberPicker)findViewById(R.id.nopicker2);
      t1 = (TextView)findViewById(R.id.seatsavailable2text);
        ratingBar3 = (RatingBar)findViewById(R.id.ratingBar6);

      refer1 = FirebaseDatabase.getInstance().getReference("/Events/Event2/seatsavailable");
      refer2 = FirebaseDatabase.getInstance().getReference(uid2 + "/Event/Event2");
      refer3 = FirebaseDatabase.getInstance().getReference(uid2+ "/Wallet");
        refer4 = FirebaseDatabase.getInstance().getReference("Events/Event2/rating");

        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bookshow-ee2bf.appspot.com/o/maroon5.jpg?alt=media&token=aebe9780-6620-42b6-bc48-59ddbbc64d9a").fit().centerCrop().into(im2);


        singernames.add("Adam Levine");
        singernames.add("Jesse Carmichael");
        singernames.add("James Valentine");
        singernames.add("PJ Morton");
        singernames.add("Matt Flynn");
        singernames.add("Sam Farrar");
        singernames.add("Mickey Madden");
        singernames.add("Ryan Dusick");


        singers.add("https://res.cloudinary.com/jerrick/image/upload/f_auto,fl_progressive,q_auto,c_fit,w_1100/fgz3lwmkjneam0fyrzpz");
        singers.add("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b3/Jesse_Carmichael_2007.11.29.jpg/220px-Jesse_Carmichael_2007.11.29.jpg");
        singers.add("https://www.martinguitar.com/media/1670/jamesvalentine-sm-images.jpg");
        singers.add("https://www.billboard.com/files/styles/article_main_image/public/media/PJ-Morton-2017-cr-Matt-Robertson-billboard-1548.jpg");
        singers.add("https://vignette.wikia.nocookie.net/maroon5/images/f/fa/Matt_Flynn-0.jpg/revision/latest?cb=20150404022347");
        singers.add("https://upload.wikimedia.org/wikipedia/commons/1/10/Sam_Farrar_-_Phantom_Planet_%282917001023%29.jpg");
        singers.add("https://vignette.wikia.nocookie.net/maroon5/images/9/91/Mickey_madden.jpg/revision/latest?cb=20150404012342");
        singers.add("https://i.pinimg.com/originals/6f/fe/e8/6ffee8fa8dda8435ff9a82afd7b8d3c7.jpg");




        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        final RecyclerView recyclerView = findViewById(R.id.recyclerview2);
        recyclerView.setLayoutManager(layoutManager);
        final RecyclerViewadapter1 recyclerViewadapter1 = new RecyclerViewadapter1(this,singernames,singers);
        recyclerView.setAdapter(recyclerViewadapter1);

        textbox.add("Maroon 5 is an American pop rock band from Los Angeles, California.It currently consists of lead vocalist Adam Levine, keyboardist and rhythm guitarist Jesse Carmichael, bassist Mickey Madden, lead guitarist James Valentine, drummer Matt Flynn, keyboardist PJ Morton and multi-instrumentalist Sam Farrar. ");
        textbox.add("Timing : 6:00 pm");
        textbox.add("Price : Rs. 80/seat");

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        final RecyclerView recyclerView1 = findViewById(R.id.recyclerview5);
        recyclerView1.setLayoutManager(layoutManager1);
        final Recyclerviewadapter2 recyclerViewadapter2 = new Recyclerviewadapter2(this,textbox);
        recyclerView1.setAdapter(recyclerViewadapter2);

        refer4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                rate1 = dataSnapshot.getValue(Double.class);
                double rat11 = rate1;
                float rat2 = (float)rat11;
                ratingBar.setRating(rat2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        refer1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatsavaialable2 = (dataSnapshot.getValue(Double.class)).intValue();
                t1.setText(" " + seatsavaialable2);
                np2.setMaxValue(seatsavaialable2);
                np2.setMinValue(1);
                np2.setWrapSelectorWheel(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refer2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ip = dataSnapshot.getValue(Double.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refer3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                current2 = dataSnapshot.getValue(Double.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double input = Double.valueOf(np2.getValue());
                if(input>seatsavaialable2)
                {
                    Toast.makeText(getApplicationContext(),"Your input exceeds the number of seats available!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    seatsavaialable2 = seatsavaialable2 - input.intValue();
                    current2 = current2- input*80;
                    input = input + ip;
                    rate1 = (rate1 + ratingBar3.getRating())/2;
                    if(current2<0)
                    {
                        Toast.makeText(Eventactivity2.this,"Insufficient Funds!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Eventactivity2.this,NewprofileActivity.class));
                    }
                    refer1.setValue(seatsavaialable2);
                    refer2.setValue(input);
                    refer3.setValue(current2);
                    refer4.setValue(rate1);
                    startActivity(new Intent(Eventactivity2.this,EventConfirm.class));
                }
            }
        });




    }
}
